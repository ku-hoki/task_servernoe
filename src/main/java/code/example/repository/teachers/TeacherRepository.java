package code.example.repository.teachers;

import code.example.entities.TeacherEntity;
import code.example.exceptions.RepositoryException;
import code.example.repository.DataBase;

import java.util.List;

public class TeacherRepository implements ITeacherRepository {

    private DataBase dataBase;

    public TeacherRepository(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public List<TeacherEntity> getAllTeachers(long teacherId) {
        return dataBase.getTeachers().values().stream().filter(teacherEntity -> teacherEntity.getIdTeacher() == teacherId).toList();
    }

    @Override
    public TeacherEntity getTeacherById(long teacherId) {
        return dataBase.getTeachers().get(teacherId);
    }

    @Override
    public long addTeacher(TeacherEntity teacher) {
        long id = dataBase.generateNextIdTeacher();
        teacher.setIdTeacher(id);
        dataBase.getTeachers().put(id, teacher);
        return id;
    }

    @Override
    public void editTeacher(TeacherEntity teacher) throws RepositoryException {

    }

    @Override
    public void deleteTeacher(long teacherId) {
        dataBase.getTeachers().remove(teacherId);
    }
}