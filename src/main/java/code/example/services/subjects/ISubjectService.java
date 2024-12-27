package code.example.services.subjects;

import code.example.entities.SubjectEntity;
import code.example.exceptions.ServiceException;
import code.example.responses.subjects.SubjectResponse;

import java.util.List;

public interface ISubjectService {

    List<SubjectResponse> getSubjects() throws ServiceException;
    SubjectResponse getSubjectById(long idSubject) throws ServiceException;
    long addSubject(SubjectEntity subject) throws ServiceException;
    void editSubject(SubjectEntity subject) throws ServiceException;
    void deleteSubject(long idSubject) throws ServiceException;
}
