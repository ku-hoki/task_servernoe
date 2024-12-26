package code.example.entities;

import java.util.Objects;
import java.time.LocalDateTime;

public class StudentEntity {
    private long id;
    private String surname;
    private String name;
    private String patronymic;
    private long idGroup;
    private StudentStatus studentStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public StudentEntity(long id, String surname, String patronymic, String name, long idGroup, StudentStatus studentStatus, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.idGroup = idGroup;
        this.studentStatus = studentStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getName() {
        return name;
    }

    public long getIdGroup() {
        return idGroup;
    }

    public StudentStatus getStudentStatus() {
        return studentStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setIdGroup(long idGroup) {
        this.idGroup = idGroup;
    }

    public void setStudentStatus(StudentStatus studentStatus) {
        this.studentStatus = studentStatus;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return id == that.id && idGroup == that.idGroup && Objects.equals(surname, that.surname) && Objects.equals(name, that.name) && Objects.equals(patronymic, that.patronymic) && studentStatus == that.studentStatus && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, patronymic, idGroup, studentStatus, createdAt, updatedAt);
    }
}
