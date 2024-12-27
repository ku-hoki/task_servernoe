package code.example.repository.teachers;

import code.example.entities.TeacherEntity;
import code.example.exceptions.RepositoryException;

import java.util.List;

public interface ITeacherRepository {

    List<TeacherEntity> getAllTeachers() throws RepositoryException;

    TeacherEntity getTeacherById(long teacherId) throws RepositoryException;
    long addTeacher(TeacherEntity teacher) throws RepositoryException;

    void editTeacher(TeacherEntity teacher) throws RepositoryException;

    void deleteTeacher(long teacherId) throws RepositoryException;
}