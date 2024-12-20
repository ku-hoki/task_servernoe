package code.example.validators.requests.students;

import code.example.entities.StudentEntity;
import code.example.exceptions.ServiceException;
import code.example.validators.requests.IValidatorService;

import java.util.List;

public class StudentValidator implements IValidatorService<StudentEntity> {

    @Override
    public List<String> validate(StudentEntity student) throws ServiceException {
        if (student == null){
            throw new ServiceException("Student cannot be null");
        }
        if (student.getName() == null)  {
            throw new ServiceException("Student Name cannot be null ");
        }
        if (student.getSurname() == null)  {
            throw new ServiceException("Student Surname cannot be null ");
        }
        if ( student.getIdGroup() <= 0) {
            throw new ServiceException("Student must belong to a existing group");
        }
        return null;
    }
}
