package ibs124.gundi.service.auth;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import ibs124.gundi.event.UserVerificationEvent;
import ibs124.gundi.mapper.UserMapper;
import ibs124.gundi.model.domain.User;
import ibs124.gundi.model.dto.RegisterDTO;
import ibs124.gundi.model.dto.RegisterResponseDTO;
import jakarta.transaction.Transactional;

@Service
class RegisterServiceImpl implements RegisterService {

    private final ApplicationEventPublisher eventPublisher;
    private final UserMapper userMapper;
    private final UserFactory userFactory;

    public RegisterServiceImpl(ApplicationEventPublisher eventPublisher, UserMapper userMapper,
            UserFactory userCreatingService) {
        this.eventPublisher = eventPublisher;
        this.userMapper = userMapper;
        this.userFactory = userCreatingService;
    }

    @Override
    @Transactional
    public RegisterResponseDTO register(RegisterDTO request, String appUrl) {
        String email = request.email();

        User user = this.userFactory.createUser(
                this.userMapper.toDomainModel(request), email);

        String token = user.getToken().getValue();

        RegisterResponseDTO response = new RegisterResponseDTO(email, token);

        this.publishEvent(response, appUrl);

        return response;

    }

    private void publishEvent(RegisterResponseDTO dto, String url) {
        UserVerificationEvent event = new UserVerificationEvent(
                dto.verificationToken(),
                dto.email(),
                url);

        this.eventPublisher.publishEvent(event);
    }

}