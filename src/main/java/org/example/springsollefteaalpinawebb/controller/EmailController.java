package org.example.springsollefteaalpinawebb.controller;

import org.example.springsollefteaalpinawebb.model.Email;
import org.example.springsollefteaalpinawebb.service.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    private EmailSender emailSender;

    // So that the email is sent to the predetermined email
    @Value("${mail.recipient}")
    private String recipient;

    @PostMapping("/email")
    public void sendEmail(@RequestBody Email email) {
        try {
            // Create an email message
            email.setTo(recipient);
            email.setName("Namn: " + email.getName());
            email.setSubject("Kontakta oss");
            email.setMessage(email.getName()  + "\nFrån: " + email.getFrom() + "\nMeddelande: " + email.getMessage());

            // Send the email message with EmailService
            emailSender.sendEmail(email);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}