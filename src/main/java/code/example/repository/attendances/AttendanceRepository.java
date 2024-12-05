package code.example.repository.attendances;

import code.example.entities.LessonEntity;
import code.example.repository.DataBase;

public class AttendanceRepository implements IAttendanceRepository {

    private DataBase dataBase;

    public AttendanceRepository(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public long addAttendance(LessonEntity lesson) {
        long id = dataBase.generateNextIdLesson();
        lesson.setIdLesson(id);
        dataBase.getLessons().put(id, lesson);
        return id;
    }

    @Override
    public void deleteAttendance(long lessonId) {
        dataBase.getLessons().remove(lessonId);
    }
}
