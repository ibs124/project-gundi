package ibs124.gundi.model.dto;

import jakarta.validation.constraints.NotNull;

public record EmailVerificationSendDto(
        @NotNull String from,
        @NotNull String to,
        @NotNull String subject,
        @NotNull String text) {
}
