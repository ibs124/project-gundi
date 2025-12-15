package ibs124.gundi.service.auth;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import ibs124.gundi.event.UserVerificationEvent;
import ibs124.gundi.exception.ResourceCreatingException;
import ibs124.gundi.mapper.UserMapper;
import ibs124.gundi.model.dto.EmailCreateDTO;
import ibs124.gundi.model.dto.RegisterDTO;
import ibs124.gundi.model.dto.RegisterResponseDTO;
import jakarta.transaction.Transactional;

@Service
class RegisterServiceImpl implements RegisterService {

    private final UserMapper userMapper;
    private final UserCreatingService userCreatingService;
    private final EmailCreatingService emailCreatingService;
    private final VerificationTokenCreatingService tokenCreatingService;
    private final ApplicationEventPublisher eventPublisher;

    public RegisterServiceImpl(
            UserCreatingService userCreatingService,
            EmailCreatingService emailCreatingService,
            VerificationTokenCreatingService tokenCreatingService,
            UserMapper userMapper,
            ApplicationEventPublisher eventPublisher) {
        this.userMapper = userMapper;
        this.userCreatingService = userCreatingService;
        this.emailCreatingService = emailCreatingService;
        this.tokenCreatingService = tokenCreatingService;
        this.eventPublisher = eventPublisher;
    }

    @Override
    @Transactional
    public RegisterResponseDTO register(RegisterDTO request, String appUrl) {
        try {
            long userID = this.userCreatingService
                    .create(this.userMapper.toServiceModel(request))
                    .id();

            String email = this.emailCreatingService
                    .create(new EmailCreateDTO(userID, request.email(), true))
                    .name();

            String token = this.tokenCreatingService
                    .createByUserId(userID);

            this.eventPublisher
                    .publishEvent(new UserVerificationEvent(token, email, appUrl));

            RegisterResponseDTO response = new RegisterResponseDTO(email, token);

            return response;
        } catch (Exception e) {
            throw new ResourceCreatingException(e);
        }
    }

}