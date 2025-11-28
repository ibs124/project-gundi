package ibs124.gundi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ibs124.gundi.model.domain.UserVerificationToken;

@Repository
public interface UserVerificationTokenRepository
        extends JpaRepository<UserVerificationToken, Long> {

    Optional<UserVerificationToken> findByUserId(long id);

    boolean existsByValue(String value);

}
