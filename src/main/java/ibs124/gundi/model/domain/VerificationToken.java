package ibs124.gundi.model.domain;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "verification_tokens")
public class VerificationToken extends AbstractEntity {

    private User user;
    private String value;
    private Instant expiresAt;

    public VerificationToken() {
        super();
    }

    public VerificationToken(User user, String value, Instant expiresAt) {
        this();
        this.setUser(user);
        this.setValue(value);
        this.setExpiresAt(expiresAt);
    }

    @Valid
    @OneToOne(optional = false)
    @MapsId
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @NotBlank
    @Column(nullable = false, unique = true)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

}
