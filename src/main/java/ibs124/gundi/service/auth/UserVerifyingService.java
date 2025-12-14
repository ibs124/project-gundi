package ibs124.gundi.service.auth;

import ibs124.gundi.model.dto.UserDTO;

public interface UserVerifyingService {
    
    UserDTO verifyByToken(String token);
}
