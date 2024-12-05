package code.example.services.students;

import code.example.entities.StudentEntity;
import code.example.exceptions.ServiceException;

import java.util.List;

public interface IStudentService {

    List<StudentEntity> getStudentByGroupId(long idGroup) throws ServiceException;
    StudentEntity getStudentById(long idStudent) throws ServiceException;


}
