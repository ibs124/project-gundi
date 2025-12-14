package ibs124.gundi.service.auth;

import ibs124.gundi.model.dto.UserCreateDTO;
import ibs124.gundi.model.dto.UserDTO;

public interface UserCreatingService {

    UserDTO create(UserCreateDTO dto);
}
