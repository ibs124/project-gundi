package ibs124.gundi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ibs124.gundi.model.domain.AuthToken;

import java.time.Instant;

@Repository
public interface AuthTokenRepository
        extends JpaRepository<AuthToken, Long> {

    Optional<AuthToken> findByUserId(long id);

    Optional<AuthToken> findByValueAndExpiresAtBefore(String value, Instant expiresAt);

    boolean existsByValue(String value);

}
