package code.example.services.teachers;

import code.example.entities.TeacherEntity;
import code.example.exceptions.ServiceException;
import code.example.responses.teachers.TeacherResponse;

import java.util.List;

public interface ITeacherService {

    long addTeacher(TeacherEntity teacher) throws ServiceException;
    void editTeacher(TeacherEntity teacher) throws ServiceException;
    void deleteTeacher(long teacherId) throws ServiceException;
    TeacherResponse getTeacherById(long idTeacher) throws ServiceException;
    List<TeacherResponse> getAllTeachers() throws ServiceException;
}
