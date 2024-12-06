package code.example.services.groups;

import code.example.entities.GroupEntity;
import code.example.exceptions.ServiceException;

import java.util.List;

public interface IGroupService {

    List<GroupEntity> getStudentGroups() throws ServiceException;

    GroupEntity getStudentGroupById(long groupId) throws ServiceException;

    long addStudentGroup(GroupEntity group) throws ServiceException;

    void editStudentGroup(GroupEntity group) throws ServiceException;

    void deleteStudentGroup(long groupId) throws ServiceException;
}
