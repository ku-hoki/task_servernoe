package code.example.repository.attendances;

import code.example.entities.LessonEntity;

public interface IAttendanceRepository {

    long addAttendance(LessonEntity lessonId);

    void deleteAttendance(long lessonId);
}
