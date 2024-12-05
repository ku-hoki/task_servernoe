package code.example.validators.requests.subjects;

import code.example.requests.subjects.AddSubjectRequest;
import code.example.validators.fields.StringValidator;

import java.util.ArrayList;
import java.util.List;

public class AddSubjectRequestValidator {

    private static final int MAX_LENGTH = 1000;

    private StringValidator stringValidator;

    public AddSubjectRequestValidator(StringValidator stringValidator) {
        this.stringValidator = stringValidator;
    }

    public List<String> validate(AddSubjectRequest request){
        List<String> errors = new ArrayList<>();

        stringValidator.isNotToLong(request.getSubjectName(), MAX_LENGTH, errors, "subjectName");
        stringValidator.isNotEmpty(request.getSubjectName(), errors, "subjectName");

        return errors;
    }
}
