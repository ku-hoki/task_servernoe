package code.example.servers;

import code.example.controllers.groups.StudentGroupController;
import code.example.controllers.students.StudentController;
import code.example.exceptions.ServiceException;
import code.example.repository.DataBase;
import code.example.repository.groups.GroupRepository;
import code.example.repository.groups.IGroupRepository;
import code.example.repository.students.IStudentRepository;
import code.example.repository.students.StudentRepository;
import code.example.requests.groups.AddGroupStudents;
import code.example.requests.groups.EditGroupStudents;
import code.example.requests.groups.GetStudentGroupById;
import code.example.requests.students.AddStudentRequest;
import code.example.requests.students.EditStudentRequest;
import code.example.requests.students.GetStudentByIdRequest;
import code.example.requests.students.GetStudentsByGroupRequest;
import code.example.servers.handlers.Handler;
import code.example.servers.handlers.groups.*;
import code.example.servers.handlers.students.*;
import code.example.services.groups.GroupService;
import code.example.services.groups.IGroupService;
import code.example.services.students.IStudentService;
import code.example.services.students.StudentService;
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

    }

    public void init(){
        dataBase = new DataBase();
        mapper = new ObjectMapper();

        //репозитории
        studentRepository = new StudentRepository(dataBase);
        groupRepository = new GroupRepository(dataBase);

        //Сервисы
        studentService = new StudentService(studentRepository);
        groupService = new GroupService(groupRepository);

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
