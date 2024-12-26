package code.example.services.students;

import code.example.entities.StudentEntity;
import code.example.exceptions.RepositoryException;
import code.example.exceptions.ServiceException;
import code.example.responses.students.StudentResponse;

import java.util.List;

public interface IStudentService {

    List<StudentResponse> getStudentByGroupId(long idGroup) throws ServiceException;
    StudentResponse getStudentById(long idStudent) throws ServiceException;
    long addStudent(StudentEntity student) throws ServiceException;
    void editStudent(StudentEntity student) throws ServiceException;
    void deleteStudent(long studentId) throws ServiceException;


}
