package code.example.validators.requests.subjects;

import code.example.exceptions.ServiceException;
import code.example.requests.subjects.GetSubjectByIdRequest;
import code.example.validators.fields.IdValidator;
import code.example.validators.requests.IValidatorService;

import java.util.ArrayList;
import java.util.List;

public class GetSubjectRequestValidator implements IValidatorService<GetSubjectByIdRequest> {

    private IdValidator idValidator;

    public GetSubjectRequestValidator(IdValidator idValidator) {
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(GetSubjectByIdRequest entity) throws ServiceException {
        List<String> errors = new ArrayList<>();
        idValidator.idValidate(entity.getIdSubject(), errors, "idSubject");

        return errors;
    }
}
