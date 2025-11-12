package ibs124.gundi.mapper.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ibs124.gundi.config.MapStructConfig;
import ibs124.gundi.mapper.UserMapper;
import ibs124.gundi.mapper.UserRoleMapper;
import ibs124.gundi.model.api.RegisterRequest;
import ibs124.gundi.model.domain.User;

@Mapper(componentModel = MapStructConfig.SPRING_COMPONENT_MODEL, uses = UserRoleMapper.class)
interface UserMapstruct extends UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "roles", ignore = true)
    User toDomainModel(RegisterRequest src);

}
