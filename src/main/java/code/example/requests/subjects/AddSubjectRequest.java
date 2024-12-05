package code.example.requests.subjects;

import java.util.Objects;

public class AddSubjectRequest {
    private String subjectName;

    public AddSubjectRequest(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddSubjectRequest that = (AddSubjectRequest) o;
        return Objects.equals(subjectName, that.subjectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectName);
    }
}
