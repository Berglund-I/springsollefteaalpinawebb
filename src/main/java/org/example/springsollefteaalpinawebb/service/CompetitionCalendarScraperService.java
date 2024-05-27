package org.example.springsollefteaalpinawebb.service;

import org.example.springsollefteaalpinawebb.model.CompetitionCalendar;
import org.example.springsollefteaalpinawebb.controller.CompetitionCalendarController;
import org.example.springsollefteaalpinawebb.repository.CompetitionCalendarRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.Disposable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompetitionCalendarScraperService {

    private List<CompetitionCalendar> calendars = new ArrayList<>();

    public void scrapeCalendar() {
        calendars.clear();
        String url = "https://ta.skidor.com/EventCalendar.aspx?orgid=80";
        try {
            Document doc = Jsoup.connect(url).get();
            Element table = doc.getElementById("ctl00_MainRegion_CalendarList1_ListViewEvents_itemPlaceholderContainer");
            Elements rows = table.select("tr.even, tr.odd");

            for (Element row : rows) {
                Elements cells = row.select("td");
                if (cells.size() > 5) {
                    String sixthCell = cells.get(5).text();
                    String fifthCell = cells.get(4).text();
                    if ("Alpint".equals(sixthCell) && "Sollefteå A K".equals(fifthCell)) {
                        String secondCell = cells.get(1).text();
                        String thirdCell = cells.get(2).text();

                        Element eventID = row.select("span[id^=ctl00_MainRegion_CalendarList1_ListViewEvents_ctrl]").first();
                        String eventIDValue = eventID.text();

                        CompetitionCalendar calendar = new CompetitionCalendar();
                        calendar.setDate(secondCell);
                        calendar.setEvent(thirdCell);
                        calendar.setEventID(eventIDValue);

                        calendars.add(calendar);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<CompetitionCalendar> getCalendars() {
        return calendars;
    }
}