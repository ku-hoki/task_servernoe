package code.example.repository.subjects;

import code.example.entities.SubjectEntity;
import code.example.exceptions.RepositoryException;
import code.example.repository.DataBase;

import java.util.List;

public class SubjectRepository implements ISubjectRepository {

    private DataBase dataBase;

    public SubjectRepository(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public List<SubjectEntity> getAllSubjects() throws RepositoryException{
        return dataBase.getSubjects().values().stream().toList();
    }

    @Override
    public SubjectEntity getSubjectById(long subjectId) throws RepositoryException {
        return dataBase.getSubjects().get(subjectId);
    }

    @Override
    public long addSubject(SubjectEntity subject) throws RepositoryException {
        long id = dataBase.generateNextIdSubject();
        subject.setIdSubject(id);
        dataBase.getSubjects().put(id, subject);
        return id;
    }

    @Override
    public void editSubject(SubjectEntity subject) throws RepositoryException {
        if (!dataBase.getSubjects().containsKey(subject.getIdSubject())) throw new RepositoryException("Unable to edit subject: subject does not exist");
        long idSubject = subject.getIdSubject();
        dataBase.getSubjects().put(idSubject, subject);
    }

    @Override
    public void deleteSubject(long subjectId) throws RepositoryException {
        dataBase.getSubjects().remove(subjectId);
    }
}
