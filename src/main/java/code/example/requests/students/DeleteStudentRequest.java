package code.example.requests.students;

public class DeleteStudentRequest {

    private long idStudent;

    public DeleteStudentRequest(long idStudent) {
        this.idStudent = idStudent;
    }

    public long getIdStudent() {
        return idStudent;
    }

}
