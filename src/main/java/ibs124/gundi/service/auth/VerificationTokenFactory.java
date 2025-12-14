package ibs124.gundi.service.auth;

import ibs124.gundi.model.domain.User;
import ibs124.gundi.model.domain.VerificationToken;

interface VerificationTokenFactory {

    VerificationToken createToken(User user);

}