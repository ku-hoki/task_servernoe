package code.example.validators.fields;

import java.util.List;

public class IdValidator {

    public void idValidate(long id, List<String> errors, String fieldName){
        if (id <= 0){
            errors.add(fieldName + " should be valid Id ");
        }
    }
}
