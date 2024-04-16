package org.example.springsollefteaalpinawebb.repository;

import org.example.springsollefteaalpinawebb.model.CompetitionCalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionCalendarRepository extends JpaRepository<CompetitionCalendar, Long> {
}
