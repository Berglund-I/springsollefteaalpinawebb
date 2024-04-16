package org.example.springsollefteaalpinawebb.controller;

import org.example.springsollefteaalpinawebb.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class MailController {

    @Autowired
    private JavaMailSender javaMailSender;

    // Så att mailet skickas till den förutbestämda mailen
    @Value("${mail.recipient}")
    private String recipient;

    @PostMapping("/mail")
    public void sendEmail(@RequestBody Mail mail) {
        try {
            // Skapa ett e-postmeddelande
            SimpleMailMessage message = new SimpleMailMessage();

            message.setTo(recipient);
            message.setSubject("New message from " + mail.getFrom());
            message.setText("Message content: " + mail.getMessage() + "\n\nFrom: " + mail.getFrom());

            // Skicka e-postmeddelandet med JavaMailSender
            javaMailSender.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
