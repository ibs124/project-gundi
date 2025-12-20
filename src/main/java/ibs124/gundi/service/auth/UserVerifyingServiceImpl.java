package ibs124.gundi.service.auth;

import java.time.Instant;

import org.springframework.stereotype.Service;

import ibs124.gundi.exception.ResourceUpdatingException;
import ibs124.gundi.model.domain.User;
import ibs124.gundi.model.domain.VerificationToken;
import ibs124.gundi.repository.UserRepository;
import ibs124.gundi.repository.VerificationTokenRepository;
import jakarta.validation.Validator;

@Service
class UserVerifyingServiceImpl implements UserVerifyingService {

    private final VerificationTokenRepository tokenRepository;
    private final UserRepository userRepository;
    private final Validator validator;

    public UserVerifyingServiceImpl(
            VerificationTokenRepository tokenRepository,
            UserRepository userRepository,
            Validator validator) {
        this.tokenRepository = tokenRepository;
        this.userRepository = userRepository;
        this.validator = validator;
    }

    @Override
    public boolean verifyByToken(String request) {
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
