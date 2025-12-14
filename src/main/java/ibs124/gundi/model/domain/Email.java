package ibs124.gundi.model.domain;

import java.time.Instant;

import ibs124.gundi.config.JpaConfig;
import ibs124.gundi.validation.constraint.ValidEmail;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name = "emails")
public class Email extends AbstractEntity {

    private User user;
    private String name;
    private Instant verifiedAt;
    private boolean primary;

    public Email() {
        super();
    }

    public Email(User user, String name, boolean primary) {
        super();
        this.setUser(user);
        this.setName(name);
        this.setPrimary(primary);
    }

    @ManyToOne(optional = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ValidEmail
    @Column(nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PastOrPresent
    public Instant getVerifiedAt() {
        return verifiedAt;
    }

    public void setVerifiedAt(Instant verifiedAt) {
        this.verifiedAt = verifiedAt;
    }

    @Column(name = "is_primary", nullable = false, columnDefinition = JpaConfig.COLUMN_BOOLEAN)
    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

}
