package ibs124.gundi.model.domain;

import ibs124.gundi.model.enumm.VerificationType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "verification_tokens")
public class VerificationToken extends AbstractToken<User> {

    private VerificationType type;

    public VerificationToken() {
        super();
    }

    @Enumerated(EnumType.STRING)
    public VerificationType getType() {
        return type;
    }

    public void setType(VerificationType type) {
        this.type = type;
    }

}
