package code.example.entities;
import java.time.LocalDateTime;
import java.util.Objects;

public class GroupEntity {
    private long id;
    private String nameGroup;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public GroupEntity(long id, String nameGroup, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.nameGroup = nameGroup;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupEntity that = (GroupEntity) o;
        return id == that.id && Objects.equals(nameGroup, that.nameGroup) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameGroup, createdAt, updatedAt);
    }
}
