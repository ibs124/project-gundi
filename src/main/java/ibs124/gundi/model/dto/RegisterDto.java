package ibs124.gundi.model.dto;

import ibs124.gundi.validation.constraint.ValidUsername;

public record RegisterDto(
        String email,
        String password,
        String fullName,
        @ValidUsername String username) {
}