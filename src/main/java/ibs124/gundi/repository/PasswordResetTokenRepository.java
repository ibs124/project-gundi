package ibs124.gundi.repository;

import org.springframework.stereotype.Repository;

import ibs124.gundi.model.domain.VerificationToken;

@Repository
public interface PasswordResetTokenRepository
        extends AbstractTokenRepository<VerificationToken> {

}
