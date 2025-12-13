package ibs124.gundi.service.auth;

import java.io.UnsupportedEncodingException;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import ibs124.gundi.config.PropertyConfig;
import ibs124.gundi.model.service.EmailVerificationSendDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
class EmailSendingServiceImpl implements EmailSendingService {

    private final JavaMailSender javaMailSender;
    private final PropertyConfig properties;

    public EmailSendingServiceImpl(
            JavaMailSender javaMailSender,
            PropertyConfig properties) {
        this.javaMailSender = javaMailSender;
        this.properties = properties;
    }

    @Override
    public void send(EmailVerificationSendDto request) {
        MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();

        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);

        try {
            messageHelper.setFrom(
                    this.properties.mailFrom(), this.properties.mailDisplayName());
            messageHelper.setTo(request.to());
            messageHelper.setSubject(request.subject());
            messageHelper.setText(request.text(), true);

            this.javaMailSender.send(mimeMessage);
        } catch (MessagingException | UnsupportedEncodingException e) {
            System.err.println(e.getMessage());
        }
    }

}