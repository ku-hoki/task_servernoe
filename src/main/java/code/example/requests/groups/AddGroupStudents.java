package code.example.requests.groups;

import java.util.Objects;

public class AddGroupStudents {
    private String nameGroup;

    public AddGroupStudents(String nameGroup) {
        this.nameGroup = nameGroup;
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
        AddGroupStudents that = (AddGroupStudents) o;
        return Objects.equals(nameGroup, that.nameGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameGroup);
    }
}
