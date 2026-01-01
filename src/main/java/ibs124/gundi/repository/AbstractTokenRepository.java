package ibs124.gundi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import ibs124.gundi.model.domain.AbstractToken;

import java.time.Instant;

@NoRepositoryBean
public interface AbstractTokenRepository<T extends AbstractToken<?>>
        extends JpaRepository<T, Long> {

    Optional<T> findByOwnerId(long id);

    Optional<T> findByValueAndExpiresAtBefore(String value, Instant expiresAt);

    boolean existsByValue(String value);

}
