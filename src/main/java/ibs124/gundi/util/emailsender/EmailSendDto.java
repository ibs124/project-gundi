package ibs124.gundi.util.emailsender;

public record EmailSendDto(
        String from,
        String to,
        String subject,
        String text) implements EmailSendRequest {
}
