package code.example.repository.students;

import code.example.entities.StudentEntity;
import code.example.exceptions.RepositoryException;
import code.example.repository.DataBase;
import code.example.repository.students.IStudentRepository;

import java.util.List;

public class StudentRepository implements IStudentRepository {
    private DataBase dataBase;

    public StudentRepository(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public List<StudentEntity> getStudentsByGroup(long groupId) {
        return dataBase.getStudents().values().stream().filter(studentEntity -> studentEntity.getIdGroup() == groupId).toList();
    }

    @Override
    public StudentEntity getStudentById(long studentId)  {
        return dataBase.getStudents().get(studentId);
    }

    @Override
    public long addStudent(StudentEntity student) {
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
    public void deleteStudent(long studentId) {
        dataBase.getStudents().remove(studentId);
    }
}
