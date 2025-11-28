package ibs124.gundi.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@Valid
public record RegisterResponseDto(
        @Valid UserDto user,
        @NotBlank String verificationToken) {

}
