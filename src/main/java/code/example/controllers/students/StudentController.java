package code.example.controllers.students;

import code.example.entities.StudentEntity;
import code.example.exceptions.RepositoryException;
import code.example.exceptions.ServiceException;
import code.example.requests.groups.GetStudentGroupById;
import code.example.requests.students.*;
import code.example.responses.ResponseEntity;
import code.example.responses.students.StudentResponse;
import code.example.services.students.IStudentService;
import code.example.validators.requests.IValidatorService;
import code.example.validators.requests.IdRequestValidator;
import code.example.validators.requests.students.AddStudentRequestValidator;
import code.example.validators.requests.students.EditStudentRequestValidator;
import code.example.validators.requests.students.GetStudentByGroupRequestValidator;
import code.example.validators.requests.students.GetStudentByIdRequestValidator;

import java.time.LocalDateTime;
import java.util.List;

public class StudentController {

    private IStudentService studentService;
    private IValidatorService<GetStudentByIdRequest> getStudentByIdValidator;
    private IValidatorService<GetStudentsByGroupRequest> getStudentByGroupValidator;
    private IValidatorService<AddStudentRequest> addStudentValidator;

    private IValidatorService<EditStudentRequest> editStudentValidator;

    public StudentController(IStudentService studentService, IValidatorService<GetStudentByIdRequest> getStudentByIdValidator, IValidatorService<GetStudentsByGroupRequest> getStudentByGroupValidator, IValidatorService<AddStudentRequest> addStudentValidator, IValidatorService<EditStudentRequest> editStudentValidator) {
        this.studentService = studentService;
        this.getStudentByIdValidator = getStudentByIdValidator;
        this.getStudentByGroupValidator = getStudentByGroupValidator;
        this.addStudentValidator = addStudentValidator;
        this.editStudentValidator = editStudentValidator;
    }
    //подача StudentResponse
    public ResponseEntity<List<StudentResponse>> getStudentByGroupId(GetStudentsByGroupRequest request) throws ServiceException {

        List<String> errors = getStudentByGroupValidator.validate(request);

        if (errors.isEmpty()){
            try{
                List<StudentResponse> students = studentService.getStudentByGroupId(request.getIdGroup());
                return ResponseEntity.success(students);
            } catch (Exception e) {
                return ResponseEntity.error(500, "Сервер столкнулся с непредвиденным состоянием, которое не позволило выполнить запрос: " + e.getMessage());
            }
        } else{
            return ResponseEntity.error(400, "Validation failed:  " + String.join(", ", errors));
        }
    }

    public ResponseEntity<StudentResponse> getStudentById(GetStudentByIdRequest request) throws ServiceException {
        List<String> errors = getStudentByIdValidator.validate(request);

        if (errors.isEmpty()){
            try{
                StudentResponse student = studentService.getStudentById(request.getId());
                return ResponseEntity.success(student);
            }catch (Exception e){
                return ResponseEntity.error(404, "Student not found" + e.getMessage());
            }

        }else {
            return ResponseEntity.error(400, "Validation failed: " + String.join(", ", errors));
        }
    }

    public ResponseEntity<Long> addStusent(AddStudentRequest request) throws ServiceException {
        List<String> errors = addStudentValidator.validate(request);

        if (errors.isEmpty()){
            try {
                StudentEntity student = new StudentEntity(
                        0,
                        request.getSurname(),
                        request.getName(),
                        request.getPatronymic(),
                        request.getIdGroup(),
                        request.getStudentStatus(),
                        LocalDateTime.now(),
                        LocalDateTime.now()

                );
                long studentId = studentService.addStudent(student);
                return ResponseEntity.created(studentId);
            }catch (Exception e){
                return ResponseEntity.error(500, "Error adding student: " + e.getMessage());
            }
        }else {
            return ResponseEntity.error(400, "Validation failed: " + String.join(", ", errors));
        }
    }

    public ResponseEntity<Void> editStudent(EditStudentRequest request) throws ServiceException {
        List<String> errors = editStudentValidator.validate(request);

        if (errors.isEmpty()){

            StudentResponse existingStudent = studentService.getStudentById(request.getIdStudent());//
            if (existingStudent == null){
                return ResponseEntity.error(404, "Student not found with ID: " + request.getIdStudent());
            }
            try {
                StudentEntity student =  new StudentEntity(
                        request.getIdStudent(),
                        request.getSurname(),
                        request.getName(),
                        request.getPatronymic(),
                        request.getIdGroup(),
                        request.getStudentStatus(),
                        existingStudent.getCreatedAt(),
                        LocalDateTime.now()
                );
                studentService.editStudent(student);
                return ResponseEntity.success(null);
            }catch (Exception e){
                return ResponseEntity.error(500, "Error editing student: " + e.getMessage());
            }
        }else{
            return ResponseEntity.error(400, "Validation failed: " + String.join(", ", errors));
        }
    }

    public ResponseEntity<Void> deleteStudent(DeleteStudentRequest request){
        try{
            studentService.deleteStudent(request.getIdStudent());
            return ResponseEntity.success(null);
        } catch (Exception e) {
            return ResponseEntity.error(404, "Error deleting student: " + e.getMessage());
        }
    }
}

