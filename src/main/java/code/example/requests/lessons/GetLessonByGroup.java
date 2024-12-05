package code.example.requests.lessons;

import java.time.LocalDateTime;
import java.util.Objects;

public class GetLessonByGroup {
    private long idGroup;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public GetLessonByGroup(long idGroup, LocalDateTime startDate, LocalDateTime endDate) {
        this.idGroup = idGroup;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getIdGroup() {
        return idGroup;
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
        GetLessonByGroup that = (GetLessonByGroup) o;
        return idGroup == that.idGroup && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGroup, startDate, endDate);
    }
}
