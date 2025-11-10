package ibs124.gundi.model.domain;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractAuditableDomainModel extends AbstractDomainModel {

    public static final String CREATED_AT = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP";
    public static final String UPDATED_AT = CREATED_AT + " ON UPDATE CURRENT_TIMESTAMP";

    private Instant createdAt;
    private Instant updatedAt;

    public AbstractAuditableDomainModel() {
        super();
    }

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = CREATED_AT)
    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = UPDATED_AT)
    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
