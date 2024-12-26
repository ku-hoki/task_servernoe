package code.example.services.groups;

import code.example.entities.GroupEntity;
import code.example.exceptions.RepositoryException;
import code.example.exceptions.ServiceException;
import code.example.repository.groups.IGroupRepository;
import code.example.responses.groups.GroupResponse;
import code.example.validators.requests.IValidatorService;

import javax.xml.validation.Validator;
import java.util.List;
import java.util.stream.Collectors;

public class GroupService implements IGroupService{

    private final IGroupRepository groupRepository;

    private GroupResponse convertToResponse(GroupEntity groupEntity){
        return GroupResponse.fromEntity(groupEntity);
    }

    public GroupService(IGroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<GroupResponse> getStudentGroups() throws ServiceException {
        try{
            List<GroupEntity> groups = groupRepository.getStudentGroups();
            return groups.stream().map(this::convertToResponse).collect(Collectors.toList());
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to get groups" + e.getMessage(), e);
        }
    }

    @Override
    public GroupResponse getStudentGroupById(long groupId) throws ServiceException {
        try{
            GroupEntity group = groupRepository.getStudentGroupById(groupId);
            return convertToResponse(group);
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to get group by ID: " + e.getMessage(), e);
        }
    }

    @Override
    public long addStudentGroup(GroupEntity group) throws ServiceException {
        try{
            return groupRepository.addStudentGroup(group);
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to add student group: " + e.getMessage(), e);
        }
    }

    @Override
    public void editStudentGroup(GroupEntity group) throws ServiceException {

        try {
            groupRepository.editStudentGroup(group);
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to edit student group: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteStudentGroup(long groupId) throws ServiceException {
        try {
            groupRepository.deleteStudentGroup(groupId);
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to delete student group: "+ e.getMessage(), e);
        }
    }
}
