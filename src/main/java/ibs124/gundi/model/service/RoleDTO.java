package ibs124.gundi.model.service;

import ibs124.gundi.model.enumm.RoleName;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@NotNull
public record RoleDTO(@Positive long id, @NotNull RoleName name) {
}
