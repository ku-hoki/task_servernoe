package code.example.requests.teachers;

public class DeleteTeacherRequest {

    private long idTeacher;

    public DeleteTeacherRequest(long idTeacher) {
        this.idTeacher = idTeacher;
    }

    public long getIdTeacher() {
        return idTeacher;
    }
}
