package code.example.models;

import code.example.entities.GroupEntity;
import code.example.entities.StudentEntity;
import code.example.entities.StudentStatus;

import java.time.LocalDateTime;
import java.util.Objects;

public class StudentModel {
    private long id;
    private String surname;
    private String name;
    private String patronymic;
    private GroupEntity idGroup;
    private StudentStatus studentStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public StudentModel(long id, String surname, String name, String patronymic, GroupEntity idGroup, StudentStatus studentStatus, LocalDateTime createdAt, LocalDateTime updatedAt) {
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

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public GroupEntity getIdGroup() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentModel that = (StudentModel) o;
        return id == that.id && Objects.equals(surname, that.surname) && Objects.equals(name, that.name) && Objects.equals(patronymic, that.patronymic) && Objects.equals(idGroup, that.idGroup) && studentStatus == that.studentStatus && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, patronymic, idGroup, studentStatus, createdAt, updatedAt);
    }
}
