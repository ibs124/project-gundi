package ibs124.gundi.service.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import ibs124.gundi.model.domain.Email;
import ibs124.gundi.model.domain.User;
import ibs124.gundi.repository.UserRepository;

@Component
class UserFactoryImpl implements UserFactory {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final VerificationTokenFactory tokenFactory;

    public UserFactoryImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            VerificationTokenFactory tokenCreateService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenFactory = tokenCreateService;
    }

    @Override
    public User createUser(User user, String email) {
        user.setPassword(this.passwordEncoder
                .encode(user.getPassword()));

        user.add(new Email(user, email, true));

        user = this.userRepository.saveAndFlush(user);

        user.setToken(this.tokenFactory.createToken(user));

        user = this.userRepository.save(user);

        return user;
    }
}
