package ibs124.gundi.service.user;

import org.springframework.stereotype.Service;

import ibs124.gundi.repository.EmailRepository;

@Service
class EmailReadingServiceImpl implements EmailReadingService {

    private final EmailRepository emailRepository;

    public EmailReadingServiceImpl(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public boolean existsByName(String name) {
        return emailRepository.existsByName(name);
    }

}