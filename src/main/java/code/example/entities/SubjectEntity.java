package code.example.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class SubjectEntity {
    private long idSubject;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public SubjectEntity(long idSubject, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.idSubject = idSubject;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public long getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(long idSubject) {
        this.idSubject = idSubject;
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
        SubjectEntity that = (SubjectEntity) o;
        return idSubject == that.idSubject && Objects.equals(name, that.name) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSubject, name, createdAt, updatedAt);
    }
}
