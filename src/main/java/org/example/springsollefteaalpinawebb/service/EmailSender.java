package org.example.springsollefteaalpinawebb.service;

import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailSender {

    @Value("${sendgrid.api.key}")
    private String sendGridAPIKey;

    public void sendEmail(org.example.springsollefteaalpinawebb.model.Email email) {
        com.sendgrid.helpers.mail.objects.Email fromEmail = new com.sendgrid.helpers.mail.objects.Email("solleftea.alpina@gmail.com"); // Your verified sender email address
        com.sendgrid.helpers.mail.objects.Email toEmail = new com.sendgrid.helpers.mail.objects.Email("solleftea.alpina@gmail.com"); // Your email address
        Content content = new Content("text/plain", email.getMessage()); // The message the user entered in the form
        Mail mail = new Mail(fromEmail, email.getSubject(), toEmail, content);

        // Set the reply-to address to the user's email address
        mail.setReplyTo(new com.sendgrid.helpers.mail.objects.Email(email.getFrom()));

        SendGrid sg = new SendGrid(sendGridAPIKey);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println("Status Code: " + response.getStatusCode());
            System.out.println("Body: " + response.getBody());
            System.out.println("Headers: " + response.getHeaders());
        } catch (IOException ex) {
            // Handle exception
            System.out.println("Error: " + ex.getMessage());
        }
    }
}