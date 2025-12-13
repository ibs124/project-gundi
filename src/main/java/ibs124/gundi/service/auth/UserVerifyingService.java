package ibs124.gundi.service.auth;

import ibs124.gundi.model.service.UserDto;

public interface UserVerifyingService {
    
    UserDto verifyByToken(String token);
}
