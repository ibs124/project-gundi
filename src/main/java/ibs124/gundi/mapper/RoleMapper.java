package ibs124.gundi.mapper;

import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import ibs124.gundi.model.domain.Role;
import ibs124.gundi.model.dto.RoleDTO;

public interface RoleMapper {

    RoleDTO toServiceModel(Role src);

    Set<RoleDTO> toServiceModelAll(Set<Role> src);

    Role toDomainModel(RoleDTO src);

    Set<Role> toDomainModelAll(Set<RoleDTO> src);

    GrantedAuthority toSecurityModel(Role src);

    Set<GrantedAuthority> toSecurityModelAll(Set<Role> src);
}
