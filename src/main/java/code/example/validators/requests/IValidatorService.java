package code.example.validators.requests;

import code.example.exceptions.ServiceException;

public interface IValidatorService<T> {
    void validate(T entity) throws ServiceException;
}
