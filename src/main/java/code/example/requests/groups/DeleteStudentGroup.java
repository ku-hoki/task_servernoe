package code.example.requests.groups;

public class DeleteStudentGroup {
    private long idGroup;

    public DeleteStudentGroup(long idGroup) {
        this.idGroup = idGroup;
    }

    public long getIdGroup() {
        return idGroup;
    }
}
