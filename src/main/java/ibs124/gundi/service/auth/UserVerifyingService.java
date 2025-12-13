package ibs124.gundi.service.auth;

import ibs124.gundi.model.service.UserDTO;

public interface UserVerifyingService {
    
    UserDTO verifyByToken(String token);
}
