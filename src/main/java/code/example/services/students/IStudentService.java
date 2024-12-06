package code.example.services.students;

import code.example.entities.StudentEntity;
import code.example.exceptions.RepositoryException;
import code.example.exceptions.ServiceException;

import java.util.List;

public interface IStudentService {

    List<StudentEntity> getStudentByGroupId(long idGroup) throws ServiceException, RepositoryException;
    StudentEntity getStudentById(long idStudent) throws ServiceException;
    long addStudent(StudentEntity student) throws ServiceException;
    void editStudent(StudentEntity student) throws ServiceException;
    void deleteStudent(long studentId) throws ServiceException;


}
