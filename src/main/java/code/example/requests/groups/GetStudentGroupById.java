package code.example.requests.groups;

public class GetStudentGroupById {
    private long idGroup;

    public GetStudentGroupById(long idGroup) {
        this.idGroup = idGroup;
    }

    public long getIdGroup() {
        return idGroup;
    }
}
