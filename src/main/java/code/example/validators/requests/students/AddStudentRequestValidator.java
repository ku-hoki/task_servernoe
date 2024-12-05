package code.example.validators.requests.students;

import code.example.requests.students.AddStudentRequest;
import code.example.validators.fields.IdValidator;
import code.example.validators.fields.StringValidator;

import java.util.ArrayList;
import java.util.List;

public class AddStudentRequestValidator {
    private static final int MAX_LENGTH = 1000;

    private IdValidator idValidator;
    private StringValidator stringValidator;

    public AddStudentRequestValidator(IdValidator idValidator, StringValidator stringValidator) {
        this.idValidator = idValidator;
        this.stringValidator = stringValidator;
    }


    public List<String> validate(AddStudentRequest request){
        List<String> list = new ArrayList<>();//список ошибок
        idValidator.idValidate(request.getIdGroup(), list, "groupId");

        stringValidator.isNotEmpty(request.getName(), list, "name");
        stringValidator.isNotToLong(request.getName(), MAX_LENGTH, list, "name");
        stringValidator.isNotEmpty(request.getSurname(), list, "surname");
        stringValidator.isNotToLong(request.getSurname(), MAX_LENGTH, list, "surname");
        stringValidator.isNotToLong(request.getPatronymic(), MAX_LENGTH, list, "patronymic");

        return list;
    }
}
