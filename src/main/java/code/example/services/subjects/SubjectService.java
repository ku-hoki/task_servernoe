package code.example.services.subjects;

import code.example.entities.SubjectEntity;
import code.example.entities.TeacherEntity;
import code.example.exceptions.RepositoryException;
import code.example.exceptions.ServiceException;
import code.example.repository.subjects.ISubjectRepository;
import code.example.responses.subjects.SubjectResponse;

import java.util.List;
import java.util.stream.Collectors;

public class SubjectService implements ISubjectService{

    private ISubjectRepository subjectRepository;

    private SubjectResponse convertToResponse(SubjectEntity subjectEntity){
        return SubjectResponse.fromEntity(subjectEntity);
    }
    public SubjectService(ISubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<SubjectResponse> getSubjects() throws ServiceException {
        try {
            List<SubjectEntity> subjects = subjectRepository.getAllSubjects();
            return subjects.stream().map(this::convertToResponse).collect(Collectors.toList());
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to retrieve all subjects:", e);
        }
    }

    @Override
    public SubjectResponse getSubjectById(long idSubject) throws ServiceException {
        try{
            SubjectEntity subject = subjectRepository.getSubjectById(idSubject);
            return convertToResponse(subject);
        } catch (RepositoryException e) {
            throw new ServiceException("Subject not found with id: " + idSubject, e);
        }
    }

    @Override
    public long addSubject(SubjectEntity subject) throws ServiceException {
        try {
            return subjectRepository.addSubject(subject);
        }catch (RepositoryException e){
            throw new ServiceException("Failed to add subject " + subject, e);
        }
    }

    @Override
    public void editSubject(SubjectEntity subject) throws ServiceException {
        try{
            subjectRepository.editSubject(subject);
        }catch (RepositoryException e){
            throw new ServiceException("Error editing subject ", e);
        }
    }

    @Override
    public void deleteSubject(long idSubject) throws ServiceException {
        try{
            subjectRepository.deleteSubject(idSubject);
        }catch (RepositoryException e){
            throw new ServiceException("Error deleting subject with ID: " + idSubject, e);
        }
    }
}
