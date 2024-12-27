package code.example.requests.subjects;

public class DeleteSubjectRequest {
    private long idSubject;

    public DeleteSubjectRequest(long idTeacher) {
        this.idSubject = idTeacher;
    }

    public long getIdSubject() {
        return idSubject;
    }
}
