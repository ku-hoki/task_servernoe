package code.example.repository;

import code.example.entities.*;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class DataBase {
    private Map<Long, StudentEntity> students;
    private Map<Long, GroupEntity> groups;
    private Map<Long, TeacherEntity> teachers;
    private Map<Long, SubjectEntity> subjects;
    private Map<Long, LessonEntity> lessons;

    private long lastIdStudent;
    private long lastIdGroup;
    private long lastIdTeacher;
    private long lastIdSubject;
    private long lastIdLesson;

    public DataBase(Map<Long, StudentEntity> students,
                    Map<Long, GroupEntity> groups,
                    Map<Long, TeacherEntity> teachers,
                    Map<Long, SubjectEntity> subjects,
                    Map<Long, LessonEntity> lessons) {
        this.students = students;
        this.groups = groups;
        this.teachers = teachers;
        this.subjects = subjects;
        this.lessons = lessons;
    }

    public long generateNextIdStudent(){
        return ++lastIdStudent;
    }

    public long generateNextIdGroup(){
        return ++lastIdGroup;
    }
    public long generateNextIdTeacher(){
        return ++lastIdTeacher;
    }
    public long generateNextIdSubject(){
        return ++lastIdSubject;
    }
    public long generateNextIdLesson(){
        return ++lastIdLesson;
    }

    public Map<Long, StudentEntity> getStudents() {
        return students;
    }

    public Map<Long, GroupEntity> getGroups() {
        return groups;
    }
    public Map<Long, TeacherEntity> getTeachers() {
        return teachers;
    }
    public Map<Long, SubjectEntity> getSubjects() {
        return subjects;
    }
    public Map<Long, LessonEntity> getLessons() {
        return lessons;
    }
}
