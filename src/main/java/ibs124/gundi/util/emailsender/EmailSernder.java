package ibs124.gundi.util.emailsender;

public interface EmailSernder {

    void send(String recipient, String subject, String message);
}
