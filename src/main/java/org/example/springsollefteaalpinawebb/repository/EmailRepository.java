package org.example.springsollefteaalpinawebb.repository;

import org.example.springsollefteaalpinawebb.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

}


