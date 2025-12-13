package ibs124.gundi.service.auth;

import ibs124.gundi.model.service.UserCreateDTO;
import ibs124.gundi.model.service.UserDTO;

public interface UserCreatingService {

    UserDTO create(UserCreateDTO dto);
}
