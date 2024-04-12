package org.example.springsollefteaalpinawebb.Service;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CompetitionCalendarScraperService {

    WebClient webClient = WebClient.create();
    String url = "https://ta.skidor.com/EventCalendar.aspx?orgid=80";




}
