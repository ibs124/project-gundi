package ibs124.gundi.mapper;

import java.util.List;

import ibs124.gundi.model.domain.UserRole;
import ibs124.gundi.model.dto.UserRoleDto;

public interface UserRoleMapper {

    UserRoleDto toServiceModel(UserRole src); 

    UserRole toDomainModel(UserRoleDto src); 

    List<UserRoleDto> toServiceModelAll(List<UserRole> src); 

    List<UserRole> toDomainModelAll(List<UserRoleDto> src); 

}

