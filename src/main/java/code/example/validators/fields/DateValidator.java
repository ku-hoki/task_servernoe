package code.example.validators.fields;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;

public class DateValidator {
    private static final String date_pattern = "\\d{2}.\\d{2}.\\d{4}";

    public void setDate_pattern(LocalDateTime date, List<String> errors, String fieldName) {
        if (date == null) {
            errors.add(fieldName + "shouldn't be null");
        } else if (!Pattern.matches(date_pattern, date.toString())) {
            errors.add(fieldName + "must follow the format DD.MM.YYYY");
        }
    }
}


