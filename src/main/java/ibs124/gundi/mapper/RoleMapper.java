package ibs124.gundi.mapper;

import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import ibs124.gundi.model.dto.RoleDto;
import ibs124.gundi.model.entity.Role;

public interface RoleMapper {

    RoleDto toServiceModel(Role src);

    Set<RoleDto> toServiceModelAll(Set<Role> src);

    Role toDomainModel(RoleDto src);

    Set<Role> toDomainModelAll(Set<RoleDto> src);

    GrantedAuthority toSecurityModel(Role src);

    Set<GrantedAuthority> toSecurityModelAll(Set<Role> src);
}
