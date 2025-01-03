package code.example.services.students;

import code.example.entities.StudentEntity;
import code.example.exceptions.RepositoryException;
import code.example.exceptions.ServiceException;
import code.example.repository.students.IStudentRepository;

import code.example.responses.students.StudentResponse;

import java.util.List;
import java.util.stream.Collectors;

public class StudentService implements IStudentService{

    private final IStudentRepository studentRepository;

    private StudentResponse convertToResponse(StudentEntity studentEntity){
        return StudentResponse.fromEntity(studentEntity);
    }

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentResponse> getStudentByGroupId(long idGroup) throws ServiceException{
        try {
            List<StudentEntity> students = studentRepository.getStudentsByGroup(idGroup);
            return students.stream().map(this::convertToResponse).collect(Collectors.toList());
        }catch (RepositoryException e){
            throw new ServiceException("Failed to retrieve students by group id:" + idGroup, e);
        }
    }

    @Override
    public StudentResponse getStudentById(long idStudent) throws ServiceException {
        try {
            StudentEntity student = studentRepository.getStudentById(idStudent);
            return convertToResponse(student);
        } catch (RepositoryException e) {
            throw new ServiceException("Student not found with id: " + idStudent, e);
        }
    }

    @Override
    public long addStudent(StudentEntity student) throws ServiceException {
        try {
            return studentRepository.addStudent(student);

        }catch (RepositoryException e) {
            throw new ServiceException("Failed to add student " + student, e);
        }
    }

    @Override
    public void editStudent(StudentEntity student) throws ServiceException {
        try {
            studentRepository.editStudent(student);
        } catch (RepositoryException e) {
            throw new ServiceException("Error editing student ", e);
        }
    }

    @Override
    public void deleteStudent(long studentId) throws ServiceException {
        try {
            studentRepository.deleteStudent(studentId);
        } catch (RepositoryException e) {
            throw new ServiceException("Error deleting student with ID: " + studentId, e);
        }

    }
}
