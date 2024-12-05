package code.example.requests.groups;

import java.util.Objects;

public class EditGroupStudents {
    private long idGroup;
    private String nameGroup;

    public EditGroupStudents(long idGroup, String nameGroup) {
        this.idGroup = idGroup;
        this.nameGroup = nameGroup;
    }

    public long getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(long idGroup) {
        this.idGroup = idGroup;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EditGroupStudents that = (EditGroupStudents) o;
        return idGroup == that.idGroup && Objects.equals(nameGroup, that.nameGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGroup, nameGroup);
    }
}
