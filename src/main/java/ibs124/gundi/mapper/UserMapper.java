package ibs124.gundi.mapper;

import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import ibs124.gundi.model.api.RegisterRequest;
import ibs124.gundi.model.domain.Role;
import ibs124.gundi.model.domain.User;
import ibs124.gundi.model.dto.RegisterDTO;

import ibs124.gundi.model.dto.UserDetailsDTO;
import jakarta.validation.Valid;

public interface UserMapper {

    GrantedAuthority toSecurityModel(Role src);

    Set<GrantedAuthority> toSecurityModelAll(Set<Role> src);

    User toDomainModel(RegisterDTO src);

    UserDetailsDTO toSecurityModel(User src);

    RegisterDTO toServiceModel(RegisterRequest bindingModel);
}
