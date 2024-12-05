package code.example.requests.teachers;

import java.util.Objects;

public class AddTeacherRequest {

    private long idGroup;
    private String surname;
    private String name;
    private String patronymic;

    public AddTeacherRequest(long idGroup, String surname, String name, String patronymic){
        this.idGroup = idGroup;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public long getIdGroup() {
        return idGroup;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddTeacherRequest that = (AddTeacherRequest) o;
        return idGroup == that.idGroup && Objects.equals(surname, that.surname) && Objects.equals(name, that.name) && Objects.equals(patronymic, that.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGroup, surname, name, patronymic);
    }
}
