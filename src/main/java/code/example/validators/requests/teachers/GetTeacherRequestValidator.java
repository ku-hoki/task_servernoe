package code.example.validators.requests.teachers;

import code.example.exceptions.ServiceException;
import code.example.requests.teachers.GetTeacherByIdRequest;
import code.example.validators.fields.IdValidator;
import code.example.validators.requests.IValidatorService;

import java.util.ArrayList;
import java.util.List;

public class GetTeacherRequestValidator implements IValidatorService<GetTeacherByIdRequest> {
    private IdValidator idValidator;

    public GetTeacherRequestValidator(IdValidator idValidator) {
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(GetTeacherByIdRequest request) throws ServiceException {
        List<String> errors = new ArrayList<>();
        idValidator.idValidate(request.getIdTeacher(), errors, "idTeacher");

        return errors;
    }
}
