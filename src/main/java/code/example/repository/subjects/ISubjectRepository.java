package code.example.repository.subjects;

import code.example.entities.SubjectEntity;
import code.example.exceptions.RepositoryException;

import java.util.List;

public interface ISubjectRepository {

    List<SubjectEntity> getAllSubjects() throws RepositoryException;

    SubjectEntity getSubjectById(long subjectId) throws RepositoryException;

    long addSubject(SubjectEntity subject) throws RepositoryException;

    void editSubject(SubjectEntity subject) throws RepositoryException;

    void deleteSubject(long subjectId) throws RepositoryException;
}