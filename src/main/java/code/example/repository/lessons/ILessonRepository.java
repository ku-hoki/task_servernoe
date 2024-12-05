package code.example.repository.lessons;

import code.example.entities.LessonEntity;
import code.example.exceptions.RepositoryException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ILessonRepository {

    long add(LessonEntity lesson);

    LessonEntity getById(long id);//получение занятия по id

    //получение всех занятий по id преподователя за заданный промежуток дат
    List<LessonEntity> getLessonByTeacherAndRangeDate(long teacherId, LocalDateTime startDate, LocalDateTime endDate) throws RepositoryException;

    // получение всех занятий по id группы за заданный промежуток дат
    List<LessonEntity> getLessonByGroupAndRangeDate(long groupId, LocalDateTime startDate, LocalDateTime endDate) throws RepositoryException;

    void deleteLessonByTeacherId(long teacherId);
    void deleteLessonByGroupId(long groupId);


}
