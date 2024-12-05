package code.example.requests.teachers;

import java.util.Objects;

public class EditTeacherRequest {
    private long idTeacher;
    private String surname;
    private String name;
    private String patronymic;
    private long idGroup;

    public EditTeacherRequest(long idTeacher, String surname, String name, String patronymic, long idGroup) {

        this.idTeacher = idTeacher;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.idGroup = idGroup;
    }

    public long getIdTeacher() {
        return idTeacher;
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

    public long getIdGroup() {
        return idGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EditTeacherRequest that = (EditTeacherRequest) o;
        return idTeacher == that.idTeacher && idGroup == that.idGroup && Objects.equals(surname, that.surname) && Objects.equals(name, that.name) && Objects.equals(patronymic, that.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTeacher, surname, name, patronymic, idGroup);
    }
}
