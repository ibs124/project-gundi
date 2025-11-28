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
    private final String officialEmail;

    public EmailSernderImpl(
            JavaMailSender javaMailSender,
            @Value("${mail_username}") String senderEmail) {
        this.javaMailSender = javaMailSender;
        this.officialEmail = senderEmail;
    }

    @Override
    public void send(EmailSendRequest request) {
        MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();

        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);

        String from = request.from() == null ? this.officialEmail : request.from();

        try {
            messageHelper.setFrom(from, "");
            messageHelper.setTo(request.to());
            messageHelper.setSubject(request.subject());
            messageHelper.setText(request.text(), true);

            this.javaMailSender.send(mimeMessage);
        } catch (MessagingException | UnsupportedEncodingException e) {
            System.err.println(e.getMessage());
        }
    }

}