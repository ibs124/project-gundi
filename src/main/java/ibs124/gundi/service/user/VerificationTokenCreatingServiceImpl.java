package ibs124.gundi.service.user;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import org.springframework.stereotype.Service;

import ibs124.gundi.exception.ResourceCreatingException;
import ibs124.gundi.model.domain.VerificationToken;
import ibs124.gundi.repository.UserRepository;
import ibs124.gundi.repository.VerificationTokenRepository;

@Service
class VerificationTokenCreatingServiceImpl implements VerificationTokenCreatingService {

    private final int tokenExpirationMinutes = 15;
    private final VerificationTokenRepository tokenRepository;
    private final UserRepository userRepository;

    public VerificationTokenCreatingServiceImpl(
            VerificationTokenRepository tokenRepository,
            UserRepository userRepository) {
        this.tokenRepository = tokenRepository;
        this.userRepository = userRepository;
    }

    @Override
    public String createByUserId(long id) {
        try {
            VerificationToken token = new VerificationToken();

            token.setUser(this.userRepository.getReferenceById(id));

            token.setValue(this.generateValue());

            token.setExpiresAt(this.generateExpiration());

            token = this.tokenRepository.save(token);

            return token.getValue();
        } catch (Exception e) {
            throw new ResourceCreatingException();
        }
    }

    private Instant generateExpiration() {
        return Instant.now().plus(this.tokenExpirationMinutes, ChronoUnit.MINUTES);
    }

    private String generateValue() {
        String value = UUID.randomUUID().toString();

        while (this.tokenRepository.existsByValue(value)) {
            value = UUID.randomUUID().toString();
        }

        return value;
    }

}
