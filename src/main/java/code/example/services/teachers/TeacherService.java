package code.example.services.teachers;

import code.example.entities.TeacherEntity;
import code.example.exceptions.RepositoryException;
import code.example.exceptions.ServiceException;
import code.example.repository.teachers.ITeacherRepository;
import code.example.responses.teachers.TeacherResponse;

import java.util.List;
import java.util.stream.Collectors;

public class TeacherService implements ITeacherService{
    private ITeacherRepository teacherRepository;
    private TeacherResponse convertToResponse(TeacherEntity teacherEntity){
        return TeacherResponse.fromEntity(teacherEntity);
    }

    public TeacherService(ITeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public long addTeacher(TeacherEntity teacher) throws ServiceException {
        try {
            return teacherRepository.addTeacher(teacher);
        }catch (RepositoryException e){
            throw new ServiceException("Failed to add teacher " + teacher, e);
        }
    }

    @Override
    public void editTeacher(TeacherEntity teacher) throws ServiceException {
        try{
            teacherRepository.editTeacher(teacher);
        }catch (RepositoryException e){
            throw new ServiceException("Error editing teacher ", e);
        }
    }

    @Override
    public void deleteTeacher(long teacherId) throws ServiceException {
        try{
            teacherRepository.deleteTeacher(teacherId);
        } catch (RepositoryException e) {
            throw new ServiceException("Error deleting teacher with ID: " + teacherId, e);
        }
    }

    @Override
    public TeacherResponse getTeacherById(long idTeacher) throws ServiceException {
        try{
            TeacherEntity teacher = teacherRepository.getTeacherById(idTeacher);
            return convertToResponse(teacher);
        } catch (RepositoryException e) {
            throw new ServiceException("Teacher not found with id: " + idTeacher, e);
        }
    }

    @Override
    public List<TeacherResponse> getAllTeachers() throws ServiceException {
        try {
            List<TeacherEntity> teachers = teacherRepository.getAllTeachers();
            return teachers.stream().map(this::convertToResponse).collect(Collectors.toList());
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to retrieve all teachers:", e);
        }
    }
}
