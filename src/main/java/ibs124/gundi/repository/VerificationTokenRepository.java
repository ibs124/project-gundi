package ibs124.gundi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ibs124.gundi.model.entity.VerificationToken;

import java.time.Instant;

@Repository
public interface VerificationTokenRepository
        extends JpaRepository<VerificationToken, Long> {

    Optional<VerificationToken> findByUserId(long id);

    Optional<VerificationToken> findByValueAndExpiresAtBefore(String value, Instant expiresAt);

    boolean existsByValue(String value);

}
