package code.example.services.students;

import code.example.entities.StudentEntity;
import code.example.exceptions.RepositoryException;
import code.example.exceptions.ServiceException;
import code.example.repository.students.StudentRepository;
import code.example.validators.requests.IValidatorService;

import java.util.List;

public class StudentService implements IStudentService{

    private final StudentRepository studentRepository;

    private final IValidatorService<StudentEntity> studentValidator;

    public StudentService(StudentRepository studentRepository, IValidatorService<StudentEntity> studentValidator) {
        this.studentRepository = studentRepository;
        this.studentValidator = studentValidator;
    }

    @Override
    public List<StudentEntity> getStudentByGroupId(long idGroup) throws ServiceException, RepositoryException {
        try {
            return studentRepository.getStudentsByGroup(idGroup);
        }catch (RepositoryException e){
            throw new ServiceException("Failed to retrieve students by group id:" + idGroup, e);
        }
    }

    @Override
    public StudentEntity getStudentById(long idStudent) throws ServiceException {
        try {
            return studentRepository.getStudentById(idStudent);
        } catch (RepositoryException e) {
            throw new ServiceException("Student not found with id: " + idStudent, e);
        }
    }

    @Override
    public long addStudent(StudentEntity student) throws ServiceException {
        studentValidator.validate(student);
        try {
            return studentRepository.addStudent(student);

        }catch (RepositoryException e) {
            throw new ServiceException("Failed to add student " + student, e);
        }
    }

    @Override
    public void editStudent(StudentEntity student) throws ServiceException {
        studentValidator.validate(student);
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
