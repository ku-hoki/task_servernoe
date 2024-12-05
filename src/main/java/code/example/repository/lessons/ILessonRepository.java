package code.example.repository.lessons;

import code.example.entities.LessonEntity;

import java.time.LocalDate;
import java.util.List;

public interface ILessonRepository {

    long add(LessonEntity lesson);

    LessonEntity getById(long id);//получение занятия по id

    //получение всех занятий по id преподователя за заданный промежуток дат
    List<LessonEntity> getLessonByTeacherAndRangeDate(long teacherId, LocalDate startDate, LocalDate endDate);

    // получение всех занятий по id группы за заданный промежуток дат
    List<LessonEntity> getLessonByGroupAndRangeDate(long groupId, LocalDate startDate, LocalDate endDate);

    void deleteLessonByTeacherId(long teacherId);
    void deleteLessonByGroupId(long groupId);


}
