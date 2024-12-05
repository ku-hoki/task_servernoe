package code.example.repository.students;

import code.example.entities.StudentEntity;
import code.example.exceptions.RepositoryException;

import java.util.List;

public interface IStudentRepository {

    List<StudentEntity> getStudentsByGroup(long groupId) throws RepositoryException;

    StudentEntity getStudentById(long studentId) throws RepositoryException;

    long addStudent(StudentEntity student) throws RepositoryException;

    void editStudent(StudentEntity student) throws RepositoryException;

    void deleteStudent(long studentId) throws RepositoryException;
}
