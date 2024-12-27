package code.example.controllers.subjects;

import code.example.entities.SubjectEntity;
import code.example.entities.TeacherEntity;
import code.example.exceptions.ServiceException;
import code.example.requests.subjects.AddSubjectRequest;
import code.example.requests.subjects.DeleteSubjectRequest;
import code.example.requests.subjects.EditSubjectRequest;
import code.example.requests.subjects.GetSubjectByIdRequest;
import code.example.requests.teachers.DeleteTeacherRequest;
import code.example.responses.ResponseEntity;
import code.example.responses.subjects.SubjectResponse;
import code.example.responses.teachers.TeacherResponse;
import code.example.services.subjects.ISubjectService;
import code.example.validators.requests.IValidatorService;

import java.time.LocalDateTime;
import java.util.List;

public class SubjectController {
    private ISubjectService subjectService;
    private IValidatorService<AddSubjectRequest> addSubjectRequestValidator;
    private IValidatorService<EditSubjectRequest> editSubjectRequestValidator;
    private IValidatorService<GetSubjectByIdRequest> getSubjectByIdValidator;

    public SubjectController(ISubjectService subjectService, IValidatorService<AddSubjectRequest> addSubjectRequestValidator, IValidatorService<EditSubjectRequest> editSubjectRequestValidator, IValidatorService<GetSubjectByIdRequest> getSubjectByIdValidator) {
        this.subjectService = subjectService;
        this.addSubjectRequestValidator = addSubjectRequestValidator;
        this.editSubjectRequestValidator = editSubjectRequestValidator;
        this.getSubjectByIdValidator = getSubjectByIdValidator;
    }

    public ResponseEntity<Long> addSubject(AddSubjectRequest request) throws ServiceException{
        List<String> errors = addSubjectRequestValidator.validate(request);

        if (errors.isEmpty()){
            try {
                SubjectEntity subject = new SubjectEntity(
                        0,
                        request.getSubjectName(),
                        LocalDateTime.now(),
                        LocalDateTime.now()

                );
                long subjectId = subjectService.addSubject(subject);
                return ResponseEntity.created(subjectId);
            }catch (Exception e){
                return ResponseEntity.error(500, "Error adding subject: " + e.getMessage());
            }
        }else {
            return ResponseEntity.error(400, "Validation failed: " + String.join(", ", errors));
        }
    }

    public ResponseEntity<Void> editSubject(EditSubjectRequest request) throws ServiceException{
        List<String> errors = editSubjectRequestValidator.validate(request);
        if (errors.isEmpty()){

            SubjectResponse existingSubject = subjectService.getSubjectById(request.getIdSubject());//
            if (existingSubject == null){
                return ResponseEntity.error(404, "Subject not found with ID: " + request.getIdSubject());
            }
            try {
                SubjectEntity subject =  new SubjectEntity(
                        existingSubject.getIdSubject(),
                        request.getSubjectName(),
                        existingSubject.getCreatedAt(),
                        LocalDateTime.now()
                );
                subjectService.editSubject(subject);
                return ResponseEntity.success(null);
            }catch (Exception e){
                return ResponseEntity.error(500, "Error editing subject: " + e.getMessage());
            }
        }else{
            return ResponseEntity.error(400, "Validation failed: " + String.join(", ", errors));
        }
    }

    public ResponseEntity<SubjectResponse> getSubjectById(GetSubjectByIdRequest request)throws ServiceException{
        List<String> errors = getSubjectByIdValidator.validate(request);

        if (errors.isEmpty()){
            try{
                SubjectResponse subject = subjectService.getSubjectById(request.getIdSubject());
                return ResponseEntity.success(subject);
            }catch (Exception e){
                return ResponseEntity.error(404, "Subject not found" + e.getMessage());
            }

        }else {
            return ResponseEntity.error(400, "Validation failed: " + String.join(", ", errors));
        }
    }

    public ResponseEntity<List<SubjectResponse>> getSubjects(){
        try{
            List<SubjectResponse> subjects = subjectService.getSubjects();
            return ResponseEntity.success(subjects);
        } catch (ServiceException e) {
            return ResponseEntity.error(315, "Unable to get subjects");
        }
    }
    public ResponseEntity<Void> deleteSubject(DeleteSubjectRequest request){
        try{
            subjectService.deleteSubject(request.getIdSubject());
            return ResponseEntity.success(null);
        } catch (ServiceException e) {
            return ResponseEntity.error(404, "Error deleting subject: " + e.getMessage());
        }
    }
}
