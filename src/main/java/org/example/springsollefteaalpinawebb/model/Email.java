package org.example.springsollefteaalpinawebb.model;

import jakarta.persistence.*;

@Entity
@Table (name="mail")
public class Email {

    private String from;
    private String to;
    private String subject;
    private String message;
    @Id
    private Long id;

    public Email() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
