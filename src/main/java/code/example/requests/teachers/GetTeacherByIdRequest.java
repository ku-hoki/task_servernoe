package code.example.requests.teachers;

public class GetTeacherByIdRequest {
    private long idTeacher;

    public GetTeacherByIdRequest(long idTeacher) {
        this.idTeacher = idTeacher;
    }

    public long getIdTeacher() {
        return idTeacher;
    }
}
