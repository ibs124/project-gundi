package ibs124.gundi.model.service;

import ibs124.gundi.validation.constraint.ValidEmail;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@NotNull
public record RegisterResponseDto(
        @ValidEmail String email,
        @NotBlank String verificationToken) {

}
