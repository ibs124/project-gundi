package ibs124.gundi.util.emailsender;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
class EmailSernderImpl implements EmailSernder {

    private final JavaMailSender javaMailSender;
    private final String senderEmail;

    public EmailSernderImpl(
            JavaMailSender javaMailSender,
            @Value("${mail_username}") String senderEmail) {
        this.javaMailSender = javaMailSender;
        this.senderEmail = senderEmail;
    }

    @Override
    public void send(String recipient, String subject, String message) {
        MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);

        try {
            messageHelper.setFrom(this.senderEmail, "");
            messageHelper.setTo(recipient);
            messageHelper.setSubject(subject);
            messageHelper.setText(message, true);

            this.javaMailSender.send(mimeMessage);
        } catch (MessagingException | UnsupportedEncodingException e) {
            System.err.println(e.getMessage());
        }
    }

}