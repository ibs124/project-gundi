package ibs124.gundi.model.domain;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import ibs124.gundi.config.JpaConfig;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractAuditableDomainModel extends AbstractDomainModel {

    private Instant createdAt;
    private Instant updatedAt;

    public AbstractAuditableDomainModel() {
        super();
    }

    @CreatedDate
    @Column(nullable = false, updatable = false, columnDefinition = JpaConfig.COULUMN_CREATED_AT)
    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    @LastModifiedDate
    @Column(columnDefinition = JpaConfig.COULUMN_UPDATED_AT)
    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
