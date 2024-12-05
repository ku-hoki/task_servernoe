package code.example.requests.students;

import java.util.Objects;

public class AddStudentRequest {

    private String surname;
    private String name;
    private String patronymic;
    private String studentStatus;
    private long idGroup;

    public AddStudentRequest(String surname, String name, String patronymic, String studentStatus, long idGroup) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.studentStatus = studentStatus;
        this.idGroup = idGroup;
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

    public String getStudentStatus() {
        return studentStatus;
    }

    public long getIdGroup() {
        return idGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddStudentRequest that = (AddStudentRequest) o;
        return idGroup == that.idGroup && Objects.equals(surname, that.surname) && Objects.equals(name, that.name) && Objects.equals(patronymic, that.patronymic) && Objects.equals(studentStatus, that.studentStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, patronymic, studentStatus, idGroup);
    }
}
