package code.example.validators.requests.teachers;

import code.example.requests.teachers.EditTeacherRequest;
import code.example.validators.fields.IdValidator;
import code.example.validators.fields.StringValidator;

import java.util.ArrayList;
import java.util.List;

public class EditTeacherRequestValidator {

    private static final int MAX_LENGTH = 1000;

    private IdValidator idValidator;
    private StringValidator stringValidator;

    public EditTeacherRequestValidator(IdValidator idValidator, StringValidator stringValidator){
        this.idValidator = idValidator;
        this.stringValidator = stringValidator;
    }

    public List<String> validate(EditTeacherRequest request){
        List<String> errors = new ArrayList<>();

        idValidator.idValidate(request.getIdTeacher(), errors, "idTeacher");
        idValidator.idValidate(request.getIdGroup(), errors, "idGroup");
        stringValidator.isNotToLong(request.getSurname(), MAX_LENGTH, errors, "surname");
        stringValidator.isNotEmpty(request.getSurname(), errors, "surname");
        stringValidator.isNotToLong(request.getName(), MAX_LENGTH, errors, "name");
        stringValidator.isNotEmpty(request.getName(), errors, "name");
        stringValidator.isNotToLong(request.getPatronymic(), MAX_LENGTH, errors, "patronymic");
        stringValidator.isNotEmpty(request.getPatronymic(), errors, "patronymic");

        return errors;
    }
}
