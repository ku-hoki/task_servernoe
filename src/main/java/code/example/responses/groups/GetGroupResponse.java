package code.example.responses.groups;

public class GetGroupResponse {
    private long idGroup;

    public GetGroupResponse(long idGroup) {
        this.idGroup = idGroup;
    }

    public long getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(long idGroup) {
        this.idGroup = idGroup;
    }
}
