package code.example.requests.subjects;

public class GetSubjectByIdRequest {
    private long idSubject;

    public GetSubjectByIdRequest(long idSubject) {
        this.idSubject = idSubject;
    }

    public long getIdSubject() {
        return idSubject;
    }
}
