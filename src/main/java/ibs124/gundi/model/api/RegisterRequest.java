package ibs124.gundi.model.api;

import ibs124.gundi.validation.constraint.UniqueUsername;
import ibs124.gundi.validation.constraint.ValidEmail;
import ibs124.gundi.validation.constraint.ValidPassword;
import ibs124.gundi.validation.constraint.ValidUsername;

public record RegisterRequest(
        @UniqueUsername @ValidUsername String username,
        @ValidPassword String password,
        @ValidEmail String email,
        String fullName) {
}