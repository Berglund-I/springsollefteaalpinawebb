package org.example.springsollefteaalpinawebb.controller;

import org.example.springsollefteaalpinawebb.model.CompetitionCalendar;
import org.example.springsollefteaalpinawebb.repository.CompetitionCalendarRepository;
import org.example.springsollefteaalpinawebb.service.CompetitionCalendarScraperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class CompetitionCalendarController {

    @Autowired
    private CompetitionCalendarRepository competitionCalendarRepository;

    @Autowired
    private CompetitionCalendarScraperService competitionCalendarScraperService;


    @GetMapping("competitionCalendar")
    public List<CompetitionCalendar> getCompetitionCalendar(){
        List<CompetitionCalendar> existingCalendars = competitionCalendarRepository.findAll();
        if (existingCalendars.isEmpty()) {
            competitionCalendarScraperService.scrapeCalendar();
            List<CompetitionCalendar> calendars = competitionCalendarScraperService.getCalendars();
            competitionCalendarRepository.saveAll(calendars);
            return calendars;
        } else {
            return existingCalendars;
        }
    }

}
