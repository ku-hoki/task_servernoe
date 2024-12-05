package code.example.repository.lessons;

import code.example.entities.LessonEntity;
import code.example.exceptions.RepositoryException;
import code.example.repository.DataBase;
import code.example.repository.lessons.ILessonRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class LessonRepository implements ILessonRepository {

    private DataBase dataBase;

    public LessonRepository(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public long add(LessonEntity lesson) {
        long id = dataBase.generateNextIdLesson();
        lesson.setIdLesson(id);
        dataBase.getLessons().put(id, lesson);
        return id;
    }

    @Override
    public LessonEntity getById(long id) {
        return dataBase.getLessons().get(id);
    }

    @Override
    public List<LessonEntity> getLessonByTeacherAndRangeDate(long teacherId, LocalDateTime startDate, LocalDateTime endDate) throws RepositoryException{
        return dataBase.getLessons().values().stream().filter(lessonEntity -> lessonEntity.getIdTeacher() == teacherId
                && lessonEntity.getLessonData().isAfter(startDate) && lessonEntity.getLessonData().isBefore(endDate)).toList();
    }

    @Override
    public List<LessonEntity> getLessonByGroupAndRangeDate(long groupId, LocalDateTime startDate, LocalDateTime endDate) throws RepositoryException {
        return dataBase.getLessons().values().stream().filter(lessonEntity -> lessonEntity.getIdGroup() == groupId
                && lessonEntity.getLessonData().isAfter(startDate) && lessonEntity.getLessonData().isBefore(endDate)).toList();

    }

    @Override
    public void deleteLessonByTeacherId(long teacherId) {
        dataBase.getLessons().remove(teacherId);
    }

    @Override
    public void deleteLessonByGroupId(long groupId) {
        dataBase.getLessons().remove(groupId);
    }
}
