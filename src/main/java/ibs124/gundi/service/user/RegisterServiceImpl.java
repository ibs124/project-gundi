package ibs124.gundi.service.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ibs124.gundi.exception.ResourceCreatingException;
import ibs124.gundi.mapper.UserMapper;
import ibs124.gundi.model.domain.User;
import ibs124.gundi.model.dto.RegisterDto;
import ibs124.gundi.model.dto.RegisterResponseDto;
import ibs124.gundi.model.dto.UserDto;
import ibs124.gundi.repository.UserRepository;
import jakarta.transaction.Transactional;

@Service
class RegisterServiceImpl implements RegisterService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final VerificationTokenCreatingService tokenCreatingService;

    public RegisterServiceImpl(
            UserRepository userRepository,
            UserMapper userMapper,
            PasswordEncoder passwordEncoder,
            VerificationTokenCreatingService tokenCreatingService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.tokenCreatingService = tokenCreatingService;
    }

    @Override
    @Transactional
    public RegisterResponseDto register(RegisterDto request) {
        try {
            User user = this.userMapper.toDomainModel(request);

            user.setPassword(
                    this.passwordEncoder
                            .encode(user.getPassword()));

            user = this.userRepository.save(user);

            UserDto userDto = this.userMapper.toServiceModel(user);

            String token = this.tokenCreatingService
                    .createByUserId(userDto.id());

            return new RegisterResponseDto(userDto, token);
        } catch (Exception e) {
            throw new ResourceCreatingException(e);
        }
    }
}