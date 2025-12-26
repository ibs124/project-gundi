package ibs124.gundi.service.auth;

import java.time.Instant;

import org.springframework.stereotype.Service;

import ibs124.gundi.exception.ResourceUpdatingException;
import ibs124.gundi.model.domain.User;
import ibs124.gundi.model.domain.VerificationToken;
import ibs124.gundi.repository.UserRepository;
import ibs124.gundi.repository.AuthTokenRepository;
import jakarta.validation.Validator;

@Service
class VerificationServiceImpl implements VerificationService {

    private final AuthTokenRepository tokenRepository;
    private final UserRepository userRepository;
    private final Validator validator;

    public VerificationServiceImpl(
            AuthTokenRepository tokenRepository,
            UserRepository userRepository,
            Validator validator) {
        this.tokenRepository = tokenRepository;
        this.userRepository = userRepository;
        this.validator = validator;
    }

    @Override
    public boolean verifyNewUserByToken(String request) {
        try {
            VerificationToken token = this.tokenRepository
                    .findByValueAndExpiresAtBefore(request, Instant.now())
                    .filter(x -> this.validator.validate(x).isEmpty())
                    .orElseThrow(() -> new IllegalStateException());

            User user = token.getUser();

            user.setEnabled(true);

            user = this.userRepository.save(user);

            this.tokenRepository.delete(token);

            return user.isEnabled();
        } catch (Exception e) {
            throw new ResourceUpdatingException();
        }
    }

}
