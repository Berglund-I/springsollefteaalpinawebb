package org.example.springsollefteaalpinawebb.controller;

import org.example.springsollefteaalpinawebb.model.CompetitionCalendar;
import org.example.springsollefteaalpinawebb.model.CompetitionsInLandscape;
import org.example.springsollefteaalpinawebb.repository.CompetitionsInLandscapeRepository;
import org.example.springsollefteaalpinawebb.service.CompetitionsInLandscapeScraperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class CompetitionsInLandscapeController {
    @Autowired
    private CompetitionsInLandscapeRepository competitionsInLandscapeRepository;

    @Autowired
    private CompetitionsInLandscapeScraperService competitionsInLandscapeScraperService;


    @GetMapping("competitionInLandscape")
    public List<CompetitionsInLandscape> getCompetitionsInLandscape(){
        List<CompetitionsInLandscape> existingCalendars = competitionsInLandscapeRepository.findAll();
        if (existingCalendars.isEmpty()) {
            competitionsInLandscapeScraperService.scrapeCalendar();
            List<CompetitionsInLandscape> calendarsInLandscape = competitionsInLandscapeScraperService.getCalendarsInLandscape();
            competitionsInLandscapeRepository.saveAll(calendarsInLandscape);
            return calendarsInLandscape;
        } else {
            return existingCalendars;
        }
    }

}
