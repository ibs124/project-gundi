package ibs124.gundi.mapper;

import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import ibs124.gundi.model.domain.Role;
import ibs124.gundi.model.service.RoleDto;

public interface RoleMapper {

    RoleDto toServiceModel(Role src);

    Set<RoleDto> toServiceModelAll(Set<Role> src);

    Role toDomainModel(RoleDto src);

    Set<Role> toDomainModelAll(Set<RoleDto> src);

    GrantedAuthority toSecurityModel(Role src);

    Set<GrantedAuthority> toSecurityModelAll(Set<Role> src);
}
