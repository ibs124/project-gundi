package ibs124.gundi.model.domain;

import java.time.Instant;

import ibs124.gundi.config.MessageConfig;
import ibs124.gundi.model.enumm.VerificationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "verification_tokens")
public class VerificationToken extends AbstractDomainModel {

    private VerificationType type;
    private Email email;
    private User user;
    private Instant expiresAt;
    private String value;

    public VerificationToken() {
        super();
    }

    @Transient
    @AssertTrue(message = MessageConfig.EMAIL_REQUIRED)
    public boolean isEmailRequired() {
        return this.getType() == VerificationType.NEW_EMAIL
                ? this.getEmail() != null
                : true;
    }

    @Enumerated(EnumType.STRING)
    public VerificationType getType() {
        return type;
    }

    public void setType(VerificationType type) {
        this.type = type;
    }

    @OneToOne
    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    @Valid
    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Future
    @NotNull
    @Column(nullable = false)
    public Instant getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Instant expiresAt) {
        this.expiresAt = expiresAt;
    }

    @NotBlank
    @Column(nullable = false, unique = true)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
