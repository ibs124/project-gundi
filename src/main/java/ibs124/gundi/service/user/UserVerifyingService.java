package ibs124.gundi.service.user;

import ibs124.gundi.model.dto.UserDto;

public interface UserVerifyingService {
    
    UserDto verifyByToken(String token);
}
