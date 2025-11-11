package ibs124.gundi.model.api;

import ibs124.gundi.validation.constraint.ValidEmail;
import ibs124.gundi.validation.constraint.ValidUsername;

public record RegisterApiRequest(
        @ValidEmail String email,
        String password,
        String fullName,
        @ValidUsername String username) {
}