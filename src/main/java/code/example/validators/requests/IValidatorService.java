package code.example.validators.requests;

import code.example.exceptions.ServiceException;

import java.util.List;

public interface IValidatorService<T> {
    List<String> validate(T entity) throws ServiceException;
}
