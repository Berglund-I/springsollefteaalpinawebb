package org.example.springsollefteaalpinawebb.repository;

import org.example.springsollefteaalpinawebb.model.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JavaMailSenderRepository  extends JpaRepository<Mail, Long> {

}