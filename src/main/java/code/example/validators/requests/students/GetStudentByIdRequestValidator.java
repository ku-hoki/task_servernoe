package code.example.validators.requests.students;

import code.example.requests.students.GetStudentByIdRequest;
import code.example.validators.fields.IdValidator;
import code.example.validators.requests.IValidator;

import java.util.ArrayList;
import java.util.List;

public class GetStudentByIdRequestValidator implements IValidator<GetStudentByIdRequest> {

    private IdValidator idValidator;

    public GetStudentByIdRequestValidator(IdValidator idValidator) {
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(GetStudentByIdRequest request) {
        List<String> errors = new ArrayList<>();
        idValidator.idValidate(request.getId(), errors, "idStudent");
        return errors;
    }
}
