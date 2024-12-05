package code.example.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class LessonEntity{
    private long idLesson;
    private long idTeacher;
    private long idGroup;
    private long idSubject;
    private LocalDateTime lessonData;
    private int numberLesson;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public LessonEntity(long idLesson, long idTeacher, long idGroup, long idSubject, LocalDateTime lessonData, int numberLesson, LocalDateTime createdAt, LocalDateTime updatedAt) {
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

    public void setIdLesson(long idLesson) {
        this.idLesson = idLesson;
    }

    public long getIdTeacher() {
        return idTeacher;
    }

    public long getIdGroup() {
        return idGroup;
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

    public long getIdSubject() {
        return idSubject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LessonEntity that = (LessonEntity) o;
        return idLesson == that.idLesson && idTeacher == that.idTeacher && idGroup == that.idGroup && idSubject == that.idSubject && numberLesson == that.numberLesson && Objects.equals(lessonData, that.lessonData) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLesson, idTeacher, idGroup, idSubject, lessonData, numberLesson, createdAt, updatedAt);
    }
}
