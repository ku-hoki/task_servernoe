package code.example.repository.groups;

import code.example.entities.GroupEntity;
import code.example.exceptions.RepositoryException;
import code.example.repository.DataBase;

public class GroupRepository implements IGroupRepository {

    private DataBase dataBase;

    public GroupRepository(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public GroupEntity getStudentGroupById(long groupId) {
        return dataBase.getGroups().get(groupId);
    }

    @Override
    public long addStudentGroup(GroupEntity group) {
        long id = dataBase.generateNextIdGroup();
        group.setId(id);
        dataBase.getGroups().put(id, group);
        return id;
    }

    @Override
    public void editStudentGroup(GroupEntity group) throws RepositoryException {

    }

    @Override
    public void deleteStudentGroup(long groupId) {
        dataBase.getGroups().remove(groupId);
    }
}
