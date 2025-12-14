package ibs124.gundi.service.auth;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import org.springframework.stereotype.Component;

import ibs124.gundi.config.PropertyConfig;
import ibs124.gundi.model.domain.User;
import ibs124.gundi.model.domain.VerificationToken;
import ibs124.gundi.repository.VerificationTokenRepository;

@Component
class VerificationTokenFactoryImpl implements VerificationTokenFactory {

    private final VerificationTokenRepository tokenRepository;
    private final PropertyConfig config;

    public VerificationTokenFactoryImpl(VerificationTokenRepository tokenRepository,
            PropertyConfig config) {
        this.tokenRepository = tokenRepository;
        this.config = config;
    }

    @Override
    public VerificationToken createToken(User user) {
        Instant expiration = Instant
                .now()
                .plus(this.config.tokenExpirationMinutes(), ChronoUnit.MINUTES);

        String value = UUID.randomUUID().toString();

        while (this.tokenRepository.existsByValue(value)) {
            value = UUID.randomUUID().toString();
        }

        return new VerificationToken(user, value, expiration);
    }

}
