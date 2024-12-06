package code.example.services.students;

import code.example.entities.StudentEntity;
import code.example.exceptions.RepositoryException;
import code.example.exceptions.ServiceException;
import code.example.repository.students.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService{

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
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

    }

    @Override
    public void editStudent(StudentEntity student) throws ServiceException {

    }

    @Override
    public void deleteStudent(long studentId) throws ServiceException {

    }
}
