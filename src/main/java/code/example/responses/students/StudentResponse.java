package code.example.responses.students;

import code.example.entities.StudentEntity;
import code.example.entities.StudentStatus;

import java.time.LocalDateTime;

public class StudentResponse {
    private long id;
    private String surname;
    private String name;
    private String patronymic;
    private long groupId;
    private StudentStatus studentStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public StudentResponse(long id, String surname, String name, String patronymic, long groupId, StudentStatus studentStatus, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.groupId = groupId;
        this.studentStatus = studentStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public long getGroupId() {
        return groupId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public StudentStatus getStudentStatus() {
        return studentStatus;
    }


    public static StudentResponse fromEntity(StudentEntity entity){
        return new StudentResponse(
                entity.getId(),
                entity.getSurname(),
                entity.getName(),
                entity.getPatronymic(),
                entity.getIdGroup(),
                entity.getStudentStatus(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
