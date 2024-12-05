package code.example.requests.lessons;

import java.time.LocalDateTime;
import java.util.Objects;

public class EditLessonRequest {

    private long idLesson;
    private long idTeacher;
    private long idGroup;
    private long idSubject;
    private LocalDateTime lessonData;
    private int numberLesson;

    public EditLessonRequest(long idLesson, long idTeacher, long idGroup, long idSubject, LocalDateTime lessonData, int numberLesson) {
        this.idLesson = idLesson;
        this.idTeacher = idTeacher;
        this.idGroup = idGroup;
        this.idSubject = idSubject;
        this.lessonData = lessonData;
        this.numberLesson = numberLesson;
    }

    public long getIdLesson() {
        return idLesson;
    }

    public long getIdTeacher() {
        return idTeacher;
    }

    public long getIdGroup() {
        return idGroup;
    }

    public long getIdSubject() {
        return idSubject;
    }

    public LocalDateTime getLessonData() {
        return lessonData;
    }

    public int getNumberLesson() {
        return numberLesson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EditLessonRequest that = (EditLessonRequest) o;
        return idLesson == that.idLesson && idTeacher == that.idTeacher && idGroup == that.idGroup && idSubject == that.idSubject && numberLesson == that.numberLesson && Objects.equals(lessonData, that.lessonData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLesson, idTeacher, idGroup, idSubject, lessonData, numberLesson);
    }
}
