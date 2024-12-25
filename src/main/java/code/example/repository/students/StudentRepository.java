package code.example.repository.students;

import code.example.entities.StudentEntity;
import code.example.exceptions.RepositoryException;
import code.example.repository.DataBase;

import java.util.List;

public class StudentRepository implements IStudentRepository {
    private DataBase dataBase;

    public StudentRepository(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public List<StudentEntity> getStudentsByGroup(long groupId) throws RepositoryException{
        return dataBase.getStudents().values().stream().filter(studentResponse -> studentResponse.getIdGroup() == groupId).toList();
    }

    @Override
    public StudentEntity getStudentById(long studentId) throws RepositoryException  {
        return dataBase.getStudents().get(studentId);
    }

    @Override
    public long addStudent(StudentEntity student) throws RepositoryException {
        long id = dataBase.generateNextIdStudent();
        student.setId(id);
        dataBase.getStudents().put(id, student);
        return id;
    }

    @Override
    public void editStudent(StudentEntity student) throws RepositoryException {
        if(!dataBase.getStudents().containsKey(student.getId())) throw new RepositoryException("Unable to edit student: student does not exist");
        long idStudent = student.getId();
        dataBase.getStudents().put(idStudent, student);
    }

    @Override
    public void deleteStudent(long studentId) throws RepositoryException {
        dataBase.getStudents().remove(studentId);
    }
}
