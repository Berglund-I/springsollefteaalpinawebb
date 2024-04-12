package org.example.springsollefteaalpinawebb.controller;

import org.example.springsollefteaalpinawebb.model.Mail;
import org.example.springsollefteaalpinawebb.repository.JavaMailSenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class MailController {

    @Autowired
    private JavaMailSenderRepository javaMailSenderRepository;

  @PostMapping("/mail")
  public void sendEmail(@RequestBody Mail mail){
      try{
          SimpleMailMessage message = new SimpleMailMessage();
          message.setTo(mail.getTo());
          message.setSubject(mail.getSubject());
          message.setText(mail.getMessage());

      } catch (Exception e){

      }


  }
}
