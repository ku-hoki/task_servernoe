package code.example.requests.students;

public class GetStudentsByGroupRequest {
    private long idGroup;

    public GetStudentsByGroupRequest(long idGroup) {
        this.idGroup = idGroup;
    }

    public long getIdGroup() {
        return idGroup;
    }
}
