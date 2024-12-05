package code.example.requests.lessons;

import java.time.LocalDateTime;
import java.util.Objects;

public class GetLessonByTeacher {
    private long idTeacher;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public GetLessonByTeacher(long idTeacher, LocalDateTime startDate, LocalDateTime endDate) {
        this.idTeacher = idTeacher;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getIdTeacher() {
        return idTeacher;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetLessonByTeacher that = (GetLessonByTeacher) o;
        return idTeacher == that.idTeacher && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTeacher, startDate, endDate);
    }
}
