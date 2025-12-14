package ibs124.gundi.service.auth;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import ibs124.gundi.event.UserVerificationEvent;
import ibs124.gundi.exception.ResourceCreatingException;
import ibs124.gundi.mapper.UserMapper;
import ibs124.gundi.model.dto.EmailCreateDTO;
import ibs124.gundi.model.dto.EmailDTO;
import ibs124.gundi.model.dto.RegisterDTO;
import ibs124.gundi.model.dto.RegisterResponseDTO;
import ibs124.gundi.model.dto.UserDTO;
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
            UserDTO user = this.userCreatingService
                    .create(this.userMapper.toServiceModel(request));

            EmailDTO email = this.emailCreatingService
                    .create(new EmailCreateDTO(user.id(), request.email(), true));

            String token = this.tokenCreatingService
                    .createByUserId(user.id());

            RegisterResponseDTO response = new RegisterResponseDTO(email.name(), token);

            this.publishEvent(response, appUrl);

            return response;
        } catch (Exception e) {
            throw new ResourceCreatingException(e);
        }
    }

    private void publishEvent(RegisterResponseDTO dto, String url) {
        UserVerificationEvent event = new UserVerificationEvent(
                dto.verificationToken(),
                dto.email(),
                url);

        this.eventPublisher.publishEvent(event);
    }
}