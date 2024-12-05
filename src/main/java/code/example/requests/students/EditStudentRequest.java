package code.example.requests.students;

import java.util.Objects;

public class EditStudentRequest {

    private long idStudent;
    private String surname;
    private String name;
    private String patronymic;
    private long idGroup;
    private String studentStatus;

    public EditStudentRequest(long idStudent, String surname, String name, String patronymic, long idGroup, String studentStatus) {
        this.idStudent = idStudent;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.idGroup = idGroup;
        this.studentStatus = studentStatus;
    }

    public long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(long idStudent) {
        this.idStudent = idStudent;
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

    public long getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(long idGroup) {
        this.idGroup = idGroup;
    }

    public String getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EditStudentRequest that = (EditStudentRequest) o;
        return idStudent == that.idStudent && idGroup == that.idGroup && Objects.equals(surname, that.surname) && Objects.equals(name, that.name) && Objects.equals(patronymic, that.patronymic) && Objects.equals(studentStatus, that.studentStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStudent, surname, name, patronymic, idGroup, studentStatus);
    }
}
