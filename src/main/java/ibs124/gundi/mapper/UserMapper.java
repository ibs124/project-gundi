package ibs124.gundi.mapper;

import ibs124.gundi.model.api.RegisterRequest;
import ibs124.gundi.model.dto.RegisterDto;
import ibs124.gundi.model.dto.UserDetailsImpl;
import ibs124.gundi.model.dto.UserDto;
import ibs124.gundi.model.entity.User;

public interface UserMapper {

    RegisterDto toServiceModel(RegisterRequest src);

    UserDto toServiceModel(User src);

    User toDomainModel(RegisterDto src);

    UserDetailsImpl toSecurityModel(User src);

}
