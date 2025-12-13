package ibs124.gundi.service.auth;

import ibs124.gundi.model.service.EmailVerificationSendDTO;

public interface EmailSendingService {

    void send(EmailVerificationSendDTO request);
}
