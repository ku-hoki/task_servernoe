package code.example.validators.fields;

import java.util.List;

public class StringValidator {
    public void isNotEmpty(String str, List<String> errors, String fieldName){
        if (str == null || str.isEmpty()){
            errors.add(fieldName + " should be not Empty ");
        }
    }

    public void isNotToLong(String str, int maxLength, List<String> errors, String fieldName){
        if (str.length()>maxLength){
            errors.add(fieldName + " should be not longer than " + maxLength);
        }

    }
}
