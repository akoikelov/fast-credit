package kg.akoikelov.springmvcapp.mail;

import kg.akoikelov.springmvcapp.exception.GmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class MailService {

  @Autowired private JavaMailSender javaMailSender;

  @Bean
  public JavaMailSender getJavaMailSender() throws GmailException {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost("smtp.gmail.com");
    mailSender.setPort(587);

    String username = System.getenv("GMAIL_USERNAME");
    String password = System.getenv("GMAIL_PASSWORD");

    if (username == null || password == null || username.equals("") || password.equals("")) {
      throw new GmailException("Логин или пароль не переданы");
    }
    mailSender.setUsername(username);
    mailSender.setPassword(password);

    Properties props = mailSender.getJavaMailProperties();
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.debug", "true");

    return mailSender;
  }

  public void sendSimpleMessage(String subject, String text) {

    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom(System.getenv("GMAIL_USERNAME"));
    message.setTo(System.getenv("GMAIL_USERNAME"));
    message.setSubject(subject);
    message.setText(text);
    javaMailSender.send(message);
  }
}
