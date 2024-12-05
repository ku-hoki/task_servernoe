package code.example.requests.students;

public class GetStudentRequest {
    private long id;

    public GetStudentRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
