package code.example.repository.groups;

import code.example.entities.GroupEntity;
import code.example.exceptions.RepositoryException;

import java.util.List;

public interface IGroupRepository {

    List<GroupEntity> getStudentGroups() throws RepositoryException;

    GroupEntity getStudentGroupById(long groupId) throws RepositoryException;

    long addStudentGroup(GroupEntity group) throws RepositoryException;

    void editStudentGroup(GroupEntity group) throws RepositoryException;

    void deleteStudentGroup(long groupId) throws RepositoryException ;


}
