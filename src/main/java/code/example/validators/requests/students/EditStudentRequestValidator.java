package code.example.validators.requests.students;

import code.example.requests.students.EditStudentRequest;
import code.example.validators.fields.IdValidator;
import code.example.validators.fields.StringValidator;

import java.util.ArrayList;
import java.util.List;

public class EditStudentRequestValidator {
    private  static final int MAX_LENGTH = 1000;

    private IdValidator idValidator;
    private StringValidator stringValidator;

    public EditStudentRequestValidator(IdValidator idValidator, StringValidator stringValidator) {
        this.idValidator = idValidator;
        this.stringValidator = stringValidator;
    }
    public List<String> validate(EditStudentRequest request){
        List<String> list = new ArrayList<>();
        idValidator.idValidate(request.getIdStudent(), list, "studentId");
        stringValidator.isNotEmpty(request.getName(), list, "name");
        stringValidator.isNotToLong(request.getName(),MAX_LENGTH, list, "name");
        stringValidator.isNotEmpty(request.getSurname(), list, "surname");
        stringValidator.isNotToLong(request.getSurname(),MAX_LENGTH, list, "surname");
        stringValidator.isNotEmpty(request.getPatronymic(), list, "patronymic");
        stringValidator.isNotToLong(request.getPatronymic(),MAX_LENGTH, list, "patronymic");

        idValidator.idValidate(request.getIdGroup(), list, "groupId");

        stringValidator.isNotToLong(request.getStudentStatus(), MAX_LENGTH, list, "studentStatus");
        stringValidator.isNotEmpty(request.getStudentStatus(), list, "studentStatus");

        return list;
    }
}
