package code.example.controllers.teachers;

import code.example.entities.StudentEntity;
import code.example.entities.TeacherEntity;
import code.example.exceptions.ServiceException;
import code.example.requests.teachers.AddTeacherRequest;
import code.example.requests.teachers.DeleteTeacherRequest;
import code.example.requests.teachers.EditTeacherRequest;
import code.example.requests.teachers.GetTeacherByIdRequest;
import code.example.responses.ResponseEntity;
import code.example.responses.teachers.TeacherResponse;
import code.example.services.teachers.ITeacherService;
import code.example.validators.requests.IValidatorService;

import java.time.LocalDateTime;
import java.util.List;

public class TeacherController {
    private ITeacherService teacherService;
    private IValidatorService<AddTeacherRequest> addTeacherRequestValidator;
    private IValidatorService<EditTeacherRequest> editTeacherRequestValidator;
    private IValidatorService<GetTeacherByIdRequest> getTeacherByIdValidator;

    public TeacherController(ITeacherService teacherService, IValidatorService<AddTeacherRequest> addTeacherRequestValidator, IValidatorService<EditTeacherRequest> editTeacherRequestValidator, IValidatorService<GetTeacherByIdRequest> getTeacherByIdValidator) {
        this.teacherService = teacherService;
        this.addTeacherRequestValidator = addTeacherRequestValidator;
        this.editTeacherRequestValidator = editTeacherRequestValidator;
        this.getTeacherByIdValidator = getTeacherByIdValidator;
    }

    public ResponseEntity<Long> addTeacher(AddTeacherRequest request) throws ServiceException{
        List<String> errors = addTeacherRequestValidator.validate(request);

        if (errors.isEmpty()){
            try {
                TeacherEntity teacher = new TeacherEntity(
                        0,
                        request.getSurname(),
                        request.getName(),
                        request.getPatronymic(),
                        LocalDateTime.now(),
                        LocalDateTime.now()

                );
                long teacherId = teacherService.addTeacher(teacher);
                return ResponseEntity.created(teacherId);
            }catch (Exception e){
                return ResponseEntity.error(500, "Error adding teacher: " + e.getMessage());
            }
        }else {
            return ResponseEntity.error(400, "Validation failed: " + String.join(", ", errors));
        }
    }

    public ResponseEntity<Void> editTeacher(EditTeacherRequest request) throws ServiceException{
        List<String> errors = editTeacherRequestValidator.validate(request);
        if (errors.isEmpty()){

            TeacherResponse existingTeacher = teacherService.getTeacherById(request.getIdTeacher());//
            if (existingTeacher == null){
                return ResponseEntity.error(404, "Teacher not found with ID: " + request.getIdTeacher());
            }
            try {
                TeacherEntity teacher =  new TeacherEntity(
                        request.getIdTeacher(),
                        request.getSurname(),
                        request.getName(),
                        request.getPatronymic(),
                        existingTeacher.getCreatedAt(),
                        LocalDateTime.now()
                );
                teacherService.editTeacher(teacher);
                return ResponseEntity.success(null);
            }catch (Exception e){
                return ResponseEntity.error(500, "Error editing teacher: " + e.getMessage());
            }
        }else{
            return ResponseEntity.error(400, "Validation failed: " + String.join(", ", errors));
        }
    }

    public ResponseEntity<TeacherResponse> getTeacherById(GetTeacherByIdRequest request) throws ServiceException{
        List<String> errors =getTeacherByIdValidator.validate(request);

        if (errors.isEmpty()){
            try{
                TeacherResponse teacher = teacherService.getTeacherById(request.getIdTeacher());
                return ResponseEntity.success(teacher);
            }catch (Exception e){
                return ResponseEntity.error(404, "Teacher not found" + e.getMessage());
            }

        }else {
            return ResponseEntity.error(400, "Validation failed: " + String.join(", ", errors));
        }
    }

    public ResponseEntity<List<TeacherResponse>> getTeachers(){
        try{
            List<TeacherResponse> teachers = teacherService.getAllTeachers();
            return ResponseEntity.success(teachers);
        } catch (Exception e) {
            return ResponseEntity.error(315, "Unable to get teachers");
        }
    }

    public ResponseEntity<Void> deleteTeacher(DeleteTeacherRequest request){
        try{
            teacherService.deleteTeacher(request.getIdTeacher());
            return ResponseEntity.success(null);
        } catch (ServiceException e) {
            return ResponseEntity.error(404, "Error deleting teacher: " + e.getMessage());
        }
    }
}
