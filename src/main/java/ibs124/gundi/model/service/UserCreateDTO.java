package ibs124.gundi.model.service;

import ibs124.gundi.validation.constraint.UniqueUsername;
import ibs124.gundi.validation.constraint.ValidFullName;
import ibs124.gundi.validation.constraint.ValidPassword;
import ibs124.gundi.validation.constraint.ValidUsername;
import jakarta.validation.constraints.NotNull;

@NotNull
public record UserCreateDTO(
        @UniqueUsername @ValidUsername String username,
        @ValidPassword String password,
        @ValidFullName String fullName) {
}