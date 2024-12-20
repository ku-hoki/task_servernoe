package code.example.validators.requests.groups;

import code.example.entities.GroupEntity;
import code.example.exceptions.ServiceException;
import code.example.validators.requests.IValidatorService;

import java.util.List;

public class GroupValidator implements IValidatorService<GroupEntity> {

    @Override
    public List<String> validate(GroupEntity group) throws ServiceException {
        if (group == null){
            throw new ServiceException("Group cannot be null");
        }
        if (group.getNameGroup() == null){
            throw new ServiceException("Group name can not be empty");
        }
        return null;
    }
}
