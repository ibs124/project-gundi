package ibs124.gundi.mapper.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import ibs124.gundi.config.MapperConfig;
import ibs124.gundi.mapper.UserMapper;
import ibs124.gundi.model.domain.Role;
import ibs124.gundi.model.domain.User;
import ibs124.gundi.model.dto.UserDetailsDTO;

@Mapper(componentModel = MapperConfig.MAPSTRUCT_COMPONENT_MODEL)
interface UserMapstruct extends UserMapper {

    @Mapping(source = "roles", target = "authorities")
    UserDetailsDTO toSecurityModel(User x);

    @Override
    default GrantedAuthority toSecurityModel(Role src) {
        return src == null ? null : new SimpleGrantedAuthority("ROLE_" + src.getName());
    }
}
