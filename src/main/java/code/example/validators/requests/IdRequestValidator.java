package code.example.validators.requests;

import code.example.requests.idRequest;
import code.example.validators.fields.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class IdRequestValidator {
    private IdValidator idValidator;

    public IdRequestValidator(IdValidator idValidator) {
        this.idValidator = idValidator;
    }

    public List<String> validate(idRequest request){
        List<String> errors = new ArrayList<>();
        idValidator.idValidate(request.getId(), errors, "id");

        return errors;
    }
}
