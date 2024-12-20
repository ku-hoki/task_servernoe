package code.example.controllers.groups;

import code.example.entities.GroupEntity;
import code.example.exceptions.ServiceException;
import code.example.requests.groups.AddGroupStudents;
import code.example.requests.groups.DeleteStudentGroup;
import code.example.requests.groups.EditGroupStudents;
import code.example.requests.groups.GetStudentGroupById;
import code.example.responses.ResponseEntity;
import code.example.services.groups.IGroupService;
import code.example.validators.requests.IValidatorService;

import java.time.LocalDateTime;
import java.util.List;

public class StudentGroupController {
    private IGroupService groupService;
    private IValidatorService<GetStudentGroupById> getGroupByIdValidator;
    private IValidatorService<AddGroupStudents> addGroupValidator;
    private IValidatorService<EditGroupStudents> editGroupValidator;

    public StudentGroupController(IGroupService groupService, IValidatorService<GetStudentGroupById> getGroupByIdValidator, IValidatorService<AddGroupStudents> addGroupValidator, IValidatorService<EditGroupStudents> editGroupValidator) {
        this.groupService = groupService;
        this.getGroupByIdValidator = getGroupByIdValidator;
        this.addGroupValidator = addGroupValidator;
        this.editGroupValidator = editGroupValidator;
    }

    public ResponseEntity<List<GroupEntity>> getAllStudentsGroups(){

        try {
            List<GroupEntity> groups = groupService.getStudentGroups();
            return ResponseEntity.success(groups);
        }catch (Exception e){
            return ResponseEntity.error(500, "Failed to get student groups: " +e.getMessage());
        }
    }

    public ResponseEntity<GroupEntity> getStudentGroupById(GetStudentGroupById request) throws ServiceException {
        List<String> errors = getGroupByIdValidator.validate(request);
        if (errors.isEmpty()){
            try {
                GroupEntity group = groupService.getStudentGroupById(request.getIdGroup());
                return ResponseEntity.success(group);
            } catch (Exception e){
                return ResponseEntity.error(500, "Failed to get group by ID: " + e.getMessage());
            }
        } else {
            return ResponseEntity.error(400, "Validation failed" + String.join(", ", errors));
        }
    }

    public ResponseEntity<Long> addStudentGroup(AddGroupStudents request) throws ServiceException {
        List<String> errors = addGroupValidator.validate(request);

        if (errors.isEmpty()){
            try {
                GroupEntity group = new GroupEntity(
                        0,
                        request.getNameGroup(),
                        LocalDateTime.now(),
                        LocalDateTime.now()
                );
                long id = groupService.addStudentGroup(group);
                return ResponseEntity.success(id);
            }catch (Exception e){
                return ResponseEntity.error(500, "Failed to add group by ID: " + e.getMessage());
            }
        }else {
            return ResponseEntity.error(400, "Validation failed" + String.join(", ", errors));
        }
    }

    public ResponseEntity<Void> editStudentGroup(EditGroupStudents request) throws ServiceException {
        List<String> errors = editGroupValidator.validate(request);

        if (errors.isEmpty()) {
            try {
                GroupEntity existingGroup = groupService.getStudentGroupById(request.getIdGroup());
                if (existingGroup == null) {
                    return ResponseEntity.error(404, "Group not found with ID: " + request.getIdGroup());
                }

                GroupEntity group = new GroupEntity(
                        request.getIdGroup(),
                        request.getNameGroup(),
                        existingGroup.getCreatedAt(),
                        LocalDateTime.now()
                );
                groupService.editStudentGroup(group);
                return ResponseEntity.success(null);
            } catch (Exception e) {
                return ResponseEntity.error(500, "Failed to edit group by ID: " + e.getMessage());
            }
        } else {
            return ResponseEntity.error(400, "Validation failed" + String.join(", ", errors));
        }
    }

    public ResponseEntity<Void> deleteStudentGroup(DeleteStudentGroup request){
        try {
            groupService.deleteStudentGroup(request.getIdGroup());
            return ResponseEntity.success(null);
        }catch (Exception e) {
            return ResponseEntity.error(500, "Failed to delete group by ID: " + e.getMessage());
        }
    }

}
