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
    public List<SubjectEntity> getAllSubjects(long subjectId) {
        return dataBase.getSubjects().values().stream().filter(subjectEntity -> subjectEntity.getIdSubject() == subjectId).toList();
    }

    @Override
    public SubjectEntity getSubjectById(long subjectId) {
        return dataBase.getSubjects().get(subjectId);
    }

    @Override
    public long addSubject(SubjectEntity subject) {
        long id = dataBase.generateNextIdSubject();
        subject.setIdSubject(id);
        dataBase.getSubjects().put(id, subject);
        return id;
    }

    @Override
    public void editSubject(SubjectEntity subject) throws RepositoryException {

    }

    @Override
    public void deleteSubject(long subjectId) {
        dataBase.getSubjects().remove(subjectId);
    }
}
