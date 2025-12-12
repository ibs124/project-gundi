package ibs124.gundi.model.dto;

import java.time.Instant;

import ibs124.gundi.model.enumm.RoleType;

public record RoleDto(
        long id,
        Instant createdAt,
        Instant updatedAt,
        RoleType type) implements AbstractDto {
}
