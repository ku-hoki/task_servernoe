package code.example.services.students;

import code.example.entities.StudentEntity;
import code.example.exceptions.RepositoryException;
import code.example.exceptions.ServiceException;
import code.example.repository.students.StudentRepository;
import code.example.responses.students.StudentResponse;
import code.example.validators.requests.IValidatorService;

import java.util.List;
import java.util.stream.Collectors;

public class StudentService implements IStudentService{

    private final StudentRepository studentRepository;

    private StudentResponse convertToResponse(StudentEntity studentEntity){
        return StudentResponse.fromEntity(studentEntity);
    }

    public StudentService(StudentRepository studentRepository) {
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
    public long addStudent(StudentEntity student) throws ServiceException {//проверить, что существует группа с заданным айди. Через репозиторий группы вернуть айди
        try {
            return studentRepository.addStudent(student);

        }catch (RepositoryException e) {
            throw new ServiceException("Failed to add student " + student, e);
        }
    }

    @Override
    public void editStudent(StudentEntity student) throws ServiceException {// проверка на группу
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
