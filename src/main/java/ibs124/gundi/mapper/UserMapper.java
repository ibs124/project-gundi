package ibs124.gundi.mapper;

import ibs124.gundi.model.api.RegisterRequest;
import ibs124.gundi.model.domain.User;
import ibs124.gundi.model.service.RegisterDTO;
import ibs124.gundi.model.service.UserDetailsDTO;
import ibs124.gundi.model.service.UserDTO;

public interface UserMapper {

    RegisterDTO toServiceModel(RegisterRequest src);

    UserDTO toServiceModel(User src);

    User toDomainModel(RegisterDTO src);

    UserDetailsDTO toSecurityModel(User src);

}
