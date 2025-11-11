package ibs124.gundi.model.dto;

import ibs124.gundi.validation.constraint.ValidEmail;
import ibs124.gundi.validation.constraint.ValidUsername;

public record RegisterDto(
        @ValidEmail String email,
        String password,
        String fullName,
        @ValidUsername String username) {
}