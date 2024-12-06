package code.example.controllers.students;

import code.example.requests.groups.GetStudentGroupById;
import code.example.responses.students.GetStudentResponse;
import code.example.services.students.StudentService;
import code.example.validators.requests.IValidator;

import java.net.http.HttpResponse;
import java.util.List;

public class StudentController {

    private final StudentService studentService;
    private final IValidator validator;

    public StudentController(StudentService studentService, IValidator validator) {
        this.studentService = studentService;
        this.validator = validator;
    }
    /*
    public HttpResponse<List<GetStudentResponse>> getStudentsByGroup(GetStudentGroupById request){
        List<String> errors = validator.validate(request);
        if (!errors.isEmpty()){
            return new HttpResponse<>(400, null, String.join(", ", errors));
        }
        try {
            List<GetStudentResponse> students = studentService.getStudentByGroupId(request.getId());
            return new HttpResponse<>(200, students);
        } catch (Exception e) {
            return new HttpResponse<>(500, null, "Internal Server Error");
        }
    }

     */
}
