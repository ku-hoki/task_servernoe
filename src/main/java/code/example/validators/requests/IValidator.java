package code.example.validators.requests;

import java.util.List;

public interface IValidator<T> {
    List<String> validate(T request);
}
