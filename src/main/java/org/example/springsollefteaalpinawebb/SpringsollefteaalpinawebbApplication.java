package org.example.springsollefteaalpinawebb;

import org.example.springsollefteaalpinawebb.model.News;
import org.example.springsollefteaalpinawebb.repository.NewsRepository;
import org.example.springsollefteaalpinawebb.model.CompetitionCalendar;
import org.example.springsollefteaalpinawebb.repository.CompetitionCalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringsollefteaalpinawebbApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringsollefteaalpinawebbApplication.class, args);
    }

    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private CompetitionCalendarRepository competitionCalendarRepository;

    @Override
    public void run(String... args) throws Exception {
        this.newsRepository.save(new News("Läger", "Komihåg att anmäla dig till lägret sista dagen för anmälning är 22/4"));
        this.competitionCalendarRepository.save(new CompetitionCalendar("femte april", "klubbmästerskap","Sollefteå alpina klubb"));
    }
}

