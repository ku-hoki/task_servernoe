package code.example.responses.subjects;

import code.example.entities.SubjectEntity;

import java.time.LocalDateTime;

public class SubjectResponse {
    private long idSubject;
    private String nameSubject;
    private LocalDateTime createdAt;

    public SubjectResponse(long idSubject, String nameSubject, LocalDateTime createdAt) {
        this.idSubject = idSubject;
        this.nameSubject = nameSubject;
        this.createdAt = createdAt;
    }

    public long getIdSubject() {
        return idSubject;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public static SubjectResponse fromEntity(SubjectEntity entity){
        return new SubjectResponse(
                entity.getIdSubject(),
                entity.getName(),
                entity.getCreatedAt()
        );
    }

}
