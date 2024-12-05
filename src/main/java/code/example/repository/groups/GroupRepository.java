package code.example.repository.groups;

import code.example.entities.GroupEntity;
import code.example.exceptions.RepositoryException;
import code.example.repository.DataBase;

import java.util.List;

public class GroupRepository implements IGroupRepository {

    private DataBase dataBase;

    public GroupRepository(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public List<GroupEntity> getStudentGroups() throws RepositoryException {
        return dataBase.getGroups().values().stream().toList();
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
        if(!dataBase.getGroups().containsKey(group.getId()))
            throw new RepositoryException("Unable to edit group: group does not exist");
        long idGroup = group.getId();
        dataBase.getGroups().put(idGroup, group);
    }

    @Override
    public void deleteStudentGroup(long groupId) {
        dataBase.getGroups().remove(groupId);
    }

}
