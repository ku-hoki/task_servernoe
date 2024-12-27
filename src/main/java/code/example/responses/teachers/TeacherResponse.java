package code.example.responses.teachers;

import code.example.entities.StudentEntity;
import code.example.entities.TeacherEntity;
import code.example.responses.students.StudentResponse;

import java.time.LocalDateTime;

public class TeacherResponse {
    private long idTeacher;
    private String name;
    private String surname;
    private String patronymic;
    private LocalDateTime createdAt;

    public TeacherResponse(long idTeacher, String name, String surname, String patronymic, LocalDateTime createdAt) {
        this.idTeacher = idTeacher;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.createdAt = createdAt;
    }

    public long getIdTeacher() {
        return idTeacher;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public static TeacherResponse fromEntity(TeacherEntity entity){
        return new TeacherResponse(
                entity.getIdTeacher(),
                entity.getSurname(),
                entity.getName(),
                entity.getPatronymic(),
                entity.getCreatedAt()
        );
    }

}
