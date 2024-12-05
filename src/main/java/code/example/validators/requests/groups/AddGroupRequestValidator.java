package code.example.validators.requests.groups;

import code.example.requests.groups.AddGroupStudents;
import code.example.validators.fields.IdValidator;
import code.example.validators.fields.StringValidator;

import java.util.ArrayList;
import java.util.List;

public class AddGroupRequestValidator {
    private static final int MAX_LENGTH = 1000;

    private IdValidator idValidator;
    private StringValidator stringValidator;

    public AddGroupRequestValidator(IdValidator idValidator, StringValidator stringValidator) {
        this.idValidator = idValidator;
        this.stringValidator = stringValidator;
    }

    public List<String> validate(AddGroupStudents request){
        List<String> errors = new ArrayList<>();

        stringValidator.isNotEmpty(request.getNameGroup(), errors, "nameGroup");
        stringValidator.isNotToLong(request.getNameGroup(), MAX_LENGTH, errors, "nameGroup");

        return errors;
    }
}
