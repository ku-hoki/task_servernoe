package code.example.validators.requests.subjects;

import code.example.requests.subjects.EditSubjectRequest;
import code.example.validators.fields.IdValidator;
import code.example.validators.fields.StringValidator;

import java.util.ArrayList;
import java.util.List;

public class EditSubjectRequestValidator {
    private static final int MAX_LENGTH = 1000;

    private IdValidator idValidator;
    private StringValidator stringValidator;

    public EditSubjectRequestValidator(IdValidator idValidator, StringValidator stringValidator) {
        this.idValidator = idValidator;
        this.stringValidator = stringValidator;
    }

    public List<String> validate(EditSubjectRequest request){
        List<String> errors = new ArrayList<>();

        idValidator.idValidate(request.getIdSubject(), errors, "idSubject");
        stringValidator.isNotToLong(request.getSubjectName(), MAX_LENGTH, errors, "subjectName");
        stringValidator.isNotEmpty(request.getSubjectName(), errors, "subjectName");

        return errors;
    }
}
