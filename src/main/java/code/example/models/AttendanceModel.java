package code.example.models;

import code.example.entities.GroupEntity;
import code.example.entities.LessonEntity;
import code.example.entities.StudentEntity;

import java.time.LocalDateTime;

public class AttendanceModel {
    private long id;
    private GroupEntity idGroup;
    private LessonEntity idLesson;
    private StudentEntity idStudent;
    private boolean visiting;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public AttendanceModel(long id, GroupEntity idGroup, LessonEntity idLesson, StudentEntity idStudent, boolean visiting, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.idGroup = idGroup;
        this.idLesson = idLesson;
        this.idStudent = idStudent;
        this.visiting = visiting;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return id;
    }

    public GroupEntity getIdGroup() {
        return idGroup;
    }

    public LessonEntity getIdLesson() {
        return idLesson;
    }

    public StudentEntity getIdStudent() {
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

}
