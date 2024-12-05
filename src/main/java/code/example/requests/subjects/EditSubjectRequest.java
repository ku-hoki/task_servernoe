package code.example.requests.subjects;

import java.util.Objects;

public class EditSubjectRequest {
    private long idSubject;
    private String subjectName;

    public EditSubjectRequest(long idSubject, String subjectName) {
        this.idSubject = idSubject;
        this.subjectName = subjectName;
    }

    public long getIdSubject() {
        return idSubject;
    }

    public String getSubjectName() {
        return subjectName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EditSubjectRequest that = (EditSubjectRequest) o;
        return idSubject == that.idSubject && Objects.equals(subjectName, that.subjectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSubject, subjectName);
    }
}
