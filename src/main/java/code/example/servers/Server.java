package code.example.servers;

import code.example.controllers.groups.StudentGroupController;
import code.example.controllers.students.StudentController;
import code.example.controllers.subjects.SubjectController;
import code.example.controllers.teachers.TeacherController;
import code.example.exceptions.ServiceException;
import code.example.repository.DataBase;
import code.example.repository.groups.GroupRepository;
import code.example.repository.groups.IGroupRepository;
import code.example.repository.students.IStudentRepository;
import code.example.repository.students.StudentRepository;
import code.example.repository.teachers.ITeacherRepository;
import code.example.repository.teachers.TeacherRepository;
import code.example.requests.groups.AddGroupStudents;
import code.example.requests.groups.EditGroupStudents;
import code.example.requests.groups.GetStudentGroupById;
import code.example.requests.students.AddStudentRequest;
import code.example.requests.students.EditStudentRequest;
import code.example.requests.students.GetStudentByIdRequest;
import code.example.requests.students.GetStudentsByGroupRequest;
import code.example.requests.subjects.AddSubjectRequest;
import code.example.requests.subjects.EditSubjectRequest;
import code.example.requests.subjects.GetSubjectByIdRequest;
import code.example.requests.teachers.AddTeacherRequest;
import code.example.requests.teachers.EditTeacherRequest;
import code.example.requests.teachers.GetTeacherByIdRequest;
import code.example.servers.handlers.Handler;
import code.example.servers.handlers.groups.*;
import code.example.servers.handlers.students.*;
import code.example.servers.handlers.subjects.*;
import code.example.servers.handlers.teachers.*;
import code.example.services.groups.GroupService;
import code.example.services.groups.IGroupService;
import code.example.services.students.IStudentService;
import code.example.services.students.StudentService;
import code.example.services.subjects.ISubjectService;
import code.example.services.teachers.ITeacherService;
import code.example.services.teachers.TeacherService;
import code.example.validators.fields.DateValidator;
import code.example.validators.fields.IdValidator;
import code.example.validators.fields.StringValidator;
import code.example.validators.requests.IValidatorService;
import code.example.validators.requests.IdRequestValidator;
import code.example.validators.requests.groups.AddGroupRequestValidator;
import code.example.validators.requests.groups.EditGroupRequestValidator;
import code.example.validators.requests.groups.GetGroupRequestValidator;
import code.example.validators.requests.students.AddStudentRequestValidator;
import code.example.validators.requests.students.EditStudentRequestValidator;
import code.example.validators.requests.students.GetStudentByGroupRequestValidator;
import code.example.validators.requests.students.GetStudentByIdRequestValidator;
import code.example.validators.requests.subjects.AddSubjectRequestValidator;
import code.example.validators.requests.subjects.EditSubjectRequestValidator;
import code.example.validators.requests.subjects.GetSubjectRequestValidator;
import code.example.validators.requests.teachers.AddTeacherRequestValidator;
import code.example.validators.requests.teachers.EditTeacherRequestValidator;
import code.example.validators.requests.teachers.GetTeacherRequestValidator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

// объявить все сервисы, контролерры, валидаторы и их зависимости
// метод init, который создает их в нужном порядке
//методо eссept(обработка запроса), на входе все реализованные запросы -  просто строка. Возвращаетс сериализованный ответ - тоже строка.
// /endpoint json строка с телом - он должен разрезать строчку на части
// десиорилизация в нужный запрос
// вызвать нужный метод нужного контроллера
// получен структуированный ответ, его надо сериализовать в строчку
// Создать промежуточный интерфейс с классами
// в мейн два потока ввода, ридер и райтер, они работают через консоль
public class Server {
    private Map<String, Handler> handlers;

    //студенты
    private IStudentService studentService;
    private StudentController studentController;
    private IStudentRepository studentRepository;
    private IValidatorService<GetStudentByIdRequest> getStudentByIdValidator;
    private IValidatorService<GetStudentsByGroupRequest> getStudentByGroupValidator;
    private IValidatorService<AddStudentRequest> addStudentValidator;
    private IValidatorService<EditStudentRequest> editStudentValidator;

    //Группы
    private IGroupService groupService;
    private StudentGroupController groupController;
    private IGroupRepository groupRepository;
    private IValidatorService<GetStudentGroupById> getGroupByIdValidator;
    private IValidatorService<AddGroupStudents> addGroupValidator;
    private IValidatorService<EditGroupStudents> editGroupValidator;

    //Преподаватели
    private ITeacherService teacherService;
    private TeacherController teacherController;
    private ITeacherRepository teacherRepository;
    private IValidatorService<AddTeacherRequest> addTeacherValidator;
    private IValidatorService<EditTeacherRequest> editTeacherValidator;
    private IValidatorService<GetTeacherByIdRequest> getTeacherByIdValidator;

    //Предметы
    private ISubjectService subjectService;
    private SubjectController subjectController;
    private IValidatorService<AddSubjectRequest> addSubjectValidator;
    private IValidatorService<EditSubjectRequest> editSubjectValidator;
    private IValidatorService<GetSubjectByIdRequest> getSubjectByIdValidator;

    private DateValidator dateValidator;
    private IdValidator idValidator;
    private StringValidator stringValidator;

    private DataBase dataBase;
    private ObjectMapper mapper;

    public void initHandlers(){
        handlers = new HashMap<>();
        handlers.put("/addStudent", new AddStudentHandler(mapper, studentController));
        handlers.put("/editStudent", new EditStudentHandler(mapper, studentController));
        handlers.put("/getStudentById", new GetStudentByIdHandler(mapper, studentController));
        handlers.put("/getStudentByGroup", new GetStudentByGroupHandler(mapper, studentController));
        handlers.put("/deleteStudent", new DeleteStudentHandler(mapper, studentController));

        handlers.put("/addStudentGroup", new AddStudentGroupHandler(mapper, groupController));
        handlers.put("/editStudentGroup", new EditStudentGroupHandler(mapper, groupController));
        handlers.put("/deleteStudentGroup", new DeleteStudentGroupHandler(mapper, groupController));
        handlers.put("/getStudentGroupById ", new GetStudentGroupByIdHandler(mapper, groupController));
        handlers.put("/getStudentGroups", new GetStudentGroupsHandler(mapper, groupController));

        handlers.put("/addTeacher", new AddTeacherHandler(mapper, teacherController));
        handlers.put("/editTeacher", new EditTeacherHandler(mapper, teacherController));
        handlers.put("/deleteTeacher", new DeleteTeacherHandler(mapper, teacherController));
        handlers.put("/getTeacherById", new GetTeacherByIdHandler(mapper, teacherController));
        handlers.put("/getTeachers", new GetTeachersHandler(mapper, teacherController));

        handlers.put("/addSubject", new AddSubjectHandler(mapper, subjectController));
        handlers.put("/editSubject", new EditSubjectHandler(mapper, subjectController));
        handlers.put("/deleteSubject", new DeleteSubjectHandler(mapper, subjectController));
        handlers.put("/getSubjectById", new GetSubjectByIdHandler(mapper, subjectController));
        handlers.put("/getSubjects", new GetSubjectsHandler(mapper, subjectController));
    }

    public void init(){
        dataBase = new DataBase(new HashMap<>(), new HashMap<>(), new HashMap<>(), new HashMap<>(), new HashMap<>());
        mapper = new ObjectMapper();

        //репозитории
        studentRepository = new StudentRepository(dataBase);
        groupRepository = new GroupRepository(dataBase);
        teacherRepository = new TeacherRepository(dataBase);

        //Сервисы
        studentService = new StudentService(studentRepository);
        groupService = new GroupService(groupRepository);
        teacherService = new TeacherService(teacherRepository);

        //Валидаторы
        idValidator = new IdValidator();
        stringValidator = new StringValidator();

        addStudentValidator = (IValidatorService<AddStudentRequest>) new AddStudentRequestValidator(idValidator, stringValidator);
        editStudentValidator = (IValidatorService<EditStudentRequest>) new EditStudentRequestValidator(idValidator, stringValidator);
        getStudentByIdValidator = (IValidatorService<GetStudentByIdRequest>) new GetStudentByIdRequestValidator(idValidator);
        getStudentByGroupValidator = (IValidatorService<GetStudentsByGroupRequest>) new GetStudentByGroupRequestValidator(idValidator);

        getGroupByIdValidator = new GetGroupRequestValidator(idValidator);
        addGroupValidator = (IValidatorService<AddGroupStudents>) new AddGroupRequestValidator(idValidator, stringValidator);
        editGroupValidator = (IValidatorService<EditGroupStudents>) new EditGroupRequestValidator(idValidator, stringValidator);

        addTeacherValidator = (IValidatorService<AddTeacherRequest>) new AddTeacherRequestValidator(idValidator, stringValidator);
        editTeacherValidator = (IValidatorService<EditTeacherRequest>) new EditTeacherRequestValidator(idValidator, stringValidator);
        getTeacherByIdValidator = new GetTeacherRequestValidator(idValidator);

        addSubjectValidator = (IValidatorService<AddSubjectRequest>) new AddSubjectRequestValidator(stringValidator);
        editSubjectValidator = (IValidatorService<EditSubjectRequest>) new EditSubjectRequestValidator(idValidator, stringValidator);
        getSubjectByIdValidator =  new GetSubjectRequestValidator(idValidator);

        //Контроллеры
        studentController = new StudentController(
                studentService,
                getStudentByIdValidator,
                getStudentByGroupValidator,
                addStudentValidator,
                editStudentValidator
                );
        groupController = new StudentGroupController(
                groupService,
                getGroupByIdValidator,
                addGroupValidator,
                editGroupValidator
        );
        teacherController = new TeacherController(
                teacherService,
                addTeacherValidator,
                editTeacherValidator,
                getTeacherByIdValidator
        );
        subjectController = new SubjectController(
                subjectService,
                addSubjectValidator,
                editSubjectValidator,
                getSubjectByIdValidator
        );

    }

    public String accept(String request) throws JsonProcessingException, ServiceException {
        String[] parts = request.split(" ", 2);
        if (parts.length != 2) {
            return "Invalid request";
        }
        String endpoint = parts[0];
        String jsonData = parts[1];

        Handler handler = handlers.get(endpoint);
        if (handler == null) {
            return "Unknown endpoint " + endpoint;
        }
        return handler.apply(jsonData);
    }

}
