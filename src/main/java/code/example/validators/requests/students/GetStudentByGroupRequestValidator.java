package code.example.validators.requests.students;

import code.example.requests.students.GetStudentsByGroupRequest;
import code.example.validators.fields.IdValidator;
import code.example.validators.requests.IValidator;

import java.util.ArrayList;
import java.util.List;

public class GetStudentByGroupRequestValidator implements IValidator<GetStudentsByGroupRequest> {

    private IdValidator idValidator;

    public GetStudentByGroupRequestValidator(IdValidator idValidator) {
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(GetStudentsByGroupRequest request) {
        List<String> errors = new ArrayList<>();
        idValidator.idValidate(request.getIdGroup(), errors, "idGroup");

        return errors;
    }
}
