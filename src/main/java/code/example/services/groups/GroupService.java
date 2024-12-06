package code.example.services.groups;

import code.example.entities.GroupEntity;
import code.example.exceptions.RepositoryException;
import code.example.exceptions.ServiceException;
import code.example.repository.groups.IGroupRepository;
import code.example.validators.requests.IValidatorService;

import javax.xml.validation.Validator;
import java.util.List;

public class GroupService implements IGroupService{

    private final IGroupRepository groupRepository;
    private final IValidatorService<GroupEntity> groupValidator;

    public GroupService(IGroupRepository groupRepository, IValidatorService<GroupEntity> groupValidator) {
        this.groupRepository = groupRepository;
        this.groupValidator = groupValidator;
    }

    @Override
    public List<GroupEntity> getStudentGroups() throws ServiceException {
        try{
            return groupRepository.getStudentGroups();
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to get groups" + e.getMessage(), e);
        }
    }

    @Override
    public GroupEntity getStudentGroupById(long groupId) throws ServiceException {
        if (groupId <= 0){
            throw new ServiceException("Invalid group Id: " + groupId);
        }
        try{
            GroupEntity group = groupRepository.getStudentGroupById(groupId);
            if (group == null){
                throw new ServiceException("Group not found by ID: "+ groupId);
            }
            return group;
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to get group by ID: " + e.getMessage(), e);
        }
    }

    @Override
    public long addStudentGroup(GroupEntity group) throws ServiceException {
        groupValidator.validate(group);
        try{
            return groupRepository.addStudentGroup(group);
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to add student group: " + e.getMessage(), e);
        }
    }

    @Override
    public void editStudentGroup(GroupEntity group) throws ServiceException {
        groupValidator.validate(group);
        if (group.getId() <= 0){
            throw new ServiceException("The ID of the group cannot be negative");
        }
        try {
            groupRepository.editStudentGroup(group);
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to edit student group: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteStudentGroup(long groupId) throws ServiceException {
        if (groupId <= 0){
            throw new ServiceException("Invalid group ID: " + groupId);
        }
        try {
            groupRepository.deleteStudentGroup(groupId);
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to delete student group: "+ e.getMessage(), e);
        }
    }
}
