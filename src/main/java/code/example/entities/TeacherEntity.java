package code.example.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class TeacherEntity {
    private long idTeacher;
    private String surname;
    private String name;
    private String patronymic;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TeacherEntity(long idTeacher, String surname, String name, String patronymic, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.idTeacher = idTeacher;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(long idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
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
        TeacherEntity that = (TeacherEntity) o;
        return idTeacher == that.idTeacher && Objects.equals(surname, that.surname) && Objects.equals(name, that.name) && Objects.equals(patronymic, that.patronymic) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTeacher, surname, name, patronymic, createdAt, updatedAt);
    }
}
