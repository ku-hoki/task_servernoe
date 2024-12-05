package code.example.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class AttendanceEntity {
    private long idGroup;
    private long idLesson;
    private long idStudent;
    private boolean visiting;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public AttendanceEntity(long idGroup, long idLesson, long idStudent, boolean visiting, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.idGroup = idGroup;
        this.idLesson = idLesson;
        this.idStudent = idStudent;
        this.visiting = visiting;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getIdGroup() {
        return idGroup;
    }

    public long getIdLesson() {
        return idLesson;
    }

    public long getIdStudent() {
        return idStudent;
    }

    public boolean isVisiting() {
        return visiting;
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
        AttendanceEntity that = (AttendanceEntity) o;
        return idGroup == that.idGroup && idLesson == that.idLesson && idStudent == that.idStudent && visiting == that.visiting && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGroup, idLesson, idStudent, visiting, createdAt, updatedAt);
    }
}
