package code.example.models;

import code.example.entities.GroupEntity;
import code.example.entities.SubjectEntity;
import code.example.entities.TeacherEntity;

import java.time.LocalDateTime;
import java.util.Objects;

public class LessonModel {
    private long idLesson;
    private TeacherEntity idTeacher;
    private GroupEntity idGroup;
    private SubjectEntity idSubject;
    private LocalDateTime lessonData;
    private int numberLesson;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public LessonModel(long idLesson, TeacherEntity idTeacher, GroupEntity idGroup, SubjectEntity idSubject, LocalDateTime lessonData, int numberLesson, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.idLesson = idLesson;
        this.idTeacher = idTeacher;
        this.idGroup = idGroup;
        this.idSubject = idSubject;
        this.lessonData = lessonData;
        this.numberLesson = numberLesson;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getIdLesson() {
        return idLesson;
    }

    public TeacherEntity getIdTeacher() {
        return idTeacher;
    }

    public GroupEntity getIdGroup() {
        return idGroup;
    }

    public SubjectEntity getIdSubject() {
        return idSubject;
    }

    public LocalDateTime getLessonData() {
        return lessonData;
    }

    public int getNumberLesson() {
        return numberLesson;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LessonModel that = (LessonModel) o;
        return idLesson == that.idLesson && numberLesson == that.numberLesson && Objects.equals(idTeacher, that.idTeacher) && Objects.equals(idGroup, that.idGroup) && Objects.equals(idSubject, that.idSubject) && Objects.equals(lessonData, that.lessonData) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLesson, idTeacher, idGroup, idSubject, lessonData, numberLesson, createdAt, updatedAt);
    }
}
