package code.example.requests.students;

public class GetStudentByIdRequest {
    private long idStudent;

    public GetStudentByIdRequest(long idStudent) {
        this.idStudent = idStudent;
    }

    public long getId() {
        return idStudent;
    }

    public void setId(long idStudent) {
        this.idStudent = idStudent;
    }
}
