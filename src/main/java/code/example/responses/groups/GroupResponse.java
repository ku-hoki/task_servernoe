package code.example.responses.groups;

import code.example.entities.GroupEntity;

import java.time.LocalDateTime;

public class GroupResponse {
    private long idGroup;
    private String nameGroup;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public GroupResponse(long idGroup, String nameGroup, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.idGroup = idGroup;
        this.nameGroup = nameGroup;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public long getIdGroup() {
        return idGroup;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public static GroupResponse fromEntity(GroupEntity entity){
        return new GroupResponse(
                entity.getId(),
                entity.getNameGroup(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

}
