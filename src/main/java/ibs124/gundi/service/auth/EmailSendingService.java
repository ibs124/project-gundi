package ibs124.gundi.service.auth;

import ibs124.gundi.model.dto.EmailVerificationSendDto;

public interface EmailSendingService {

    void send(EmailVerificationSendDto request);
}
