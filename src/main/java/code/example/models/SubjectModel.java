package code.example.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class SubjectModel {
    private long idSubject;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public SubjectModel(long idSubject, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.idSubject = idSubject;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getIdSubject() {
        return idSubject;
    }

    public String getName() {
        return name;
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
        SubjectModel that = (SubjectModel) o;
        return idSubject == that.idSubject && Objects.equals(name, that.name) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSubject, name, createdAt, updatedAt);
    }
}
