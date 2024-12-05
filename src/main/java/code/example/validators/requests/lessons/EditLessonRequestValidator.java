package code.example.validators.requests.lessons;

import code.example.requests.lessons.EditLessonRequest;
import code.example.validators.fields.DateValidator;
import code.example.validators.fields.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class EditLessonRequestValidator {

    private static final int MAX_LENGTH = 1000;

    private IdValidator idValidator;

    private DateValidator dateValidator;

    public EditLessonRequestValidator(IdValidator idValidator, DateValidator dateValidator) {
        this.idValidator = idValidator;
        this.dateValidator = dateValidator;
    }

    public List<String> validate(EditLessonRequest request){
        List<String> errors = new ArrayList<>();

        idValidator.idValidate(request.getIdLesson(), errors, "idLesson");
        idValidator.idValidate(request.getIdTeacher(), errors, "idTeacher" );
        idValidator.idValidate(request.getIdGroup(), errors, "idGroup");
        idValidator.idValidate(request.getIdSubject(), errors, "idSubject");
        dateValidator.setDate_pattern(request.getLessonData(), errors, "lessonData");
        idValidator.idValidate(request.getNumberLesson(), errors, "numberLesson");

        return errors;
    }
}
