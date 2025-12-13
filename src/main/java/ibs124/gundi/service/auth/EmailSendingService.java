package ibs124.gundi.service.auth;

import ibs124.gundi.model.service.EmailVerificationSendDto;

public interface EmailSendingService {

    void send(EmailVerificationSendDto request);
}
