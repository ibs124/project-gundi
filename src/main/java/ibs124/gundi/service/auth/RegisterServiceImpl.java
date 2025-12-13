package ibs124.gundi.service.auth;

import org.springframework.stereotype.Service;

import ibs124.gundi.exception.ResourceCreatingException;
import ibs124.gundi.mapper.UserMapper;
import ibs124.gundi.model.service.EmailCreateDTO;
import ibs124.gundi.model.service.EmailDTO;
import ibs124.gundi.model.service.RegisterDTO;
import ibs124.gundi.model.service.RegisterResponseDTO;
import ibs124.gundi.model.service.UserCreateDTO;
import ibs124.gundi.model.service.UserDTO;
import jakarta.transaction.Transactional;

@Service
class RegisterServiceImpl implements RegisterService {

    private final UserMapper userMapper;
    private final UserCreatingService userCreatingService;
    private final EmailCreatingService emailCreatingService;
    private final VerificationTokenCreatingService tokenCreatingService;

    public RegisterServiceImpl(UserCreatingService userCreatingService, EmailCreatingService emailCreatingService,
            VerificationTokenCreatingService tokenCreatingService, UserMapper userMapper) {
        this.userMapper = userMapper;
        this.userCreatingService = userCreatingService;
        this.emailCreatingService = emailCreatingService;
        this.tokenCreatingService = tokenCreatingService;
    }

    @Override
    @Transactional
    public RegisterResponseDTO register(RegisterDTO request) {
        try {
            UserCreateDTO userCreateDTO = this.userMapper.toServiceModel(request);

            UserDTO user = this.userCreatingService.create(userCreateDTO);

            EmailDTO email = this.emailCreatingService
                    .create(new EmailCreateDTO(user.id(), request.email(), true));

            String token = this.tokenCreatingService
                    .createByUserId(user.id());

            return new RegisterResponseDTO(email.name(), token);

        } catch (Exception e) {
            throw new ResourceCreatingException(e);
        }
    }
}