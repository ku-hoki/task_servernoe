package code.example.validators.requests.groups;

import code.example.exceptions.ServiceException;
import code.example.requests.groups.GetStudentGroupById;
import code.example.validators.fields.IdValidator;
import code.example.validators.requests.IValidatorService;

import java.util.ArrayList;
import java.util.List;

public class GetGroupRequestValidator implements IValidatorService<GetStudentGroupById> {
    private IdValidator idValidator;

    public GetGroupRequestValidator(IdValidator idValidator) {
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(GetStudentGroupById request) throws ServiceException {
        List<String> errors = new ArrayList<>();
        idValidator.idValidate(request.getIdGroup(), errors, "idGroup");

        return errors;
    }
}
