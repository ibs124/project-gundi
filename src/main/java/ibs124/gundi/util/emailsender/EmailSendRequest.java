package ibs124.gundi.util.emailsender;

public interface EmailSendRequest {

    String from();

    String to();

    String subject();

    String text();

}
