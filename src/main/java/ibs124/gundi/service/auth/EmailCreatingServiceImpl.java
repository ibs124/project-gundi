package ibs124.gundi.service.auth;

import org.springframework.stereotype.Service;

import ibs124.gundi.exception.ResourceReadingException;
import ibs124.gundi.model.domain.Email;
import ibs124.gundi.model.domain.User;
import ibs124.gundi.model.service.EmailCreateDTO;
import ibs124.gundi.model.service.EmailDTO;
import ibs124.gundi.repository.EmailRepository;
import ibs124.gundi.repository.UserRepository;

@Service
class EmailCreatingServiceImpl implements EmailCreatingService {

    private final EmailRepository emailRepository;
    private final UserRepository userRepository;

    public EmailCreatingServiceImpl(EmailRepository emailRepository, UserRepository userRepository) {
        this.emailRepository = emailRepository;
        this.userRepository = userRepository;
    }

    @Override
    public EmailDTO create(EmailCreateDTO dto) {
        User user = this.userRepository
                .findById(dto.userId())
                .orElseThrow(() -> new ResourceReadingException());

        Email email = new Email();
        email.setUser(user);
        email.setPrimary(dto.primary());
        email.setName(dto.name());

        email = this.emailRepository.save(email);

        return new EmailDTO(email.getId(), null, email.getName());
    }

}