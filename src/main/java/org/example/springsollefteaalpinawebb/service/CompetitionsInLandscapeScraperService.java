package org.example.springsollefteaalpinawebb.service;

import org.example.springsollefteaalpinawebb.model.CompetitionsInLandscape;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompetitionsInLandscapeScraperService {

    private List<CompetitionsInLandscape> calendarsInLandscape = new ArrayList<>();

    public void scrapeCalendar() {
        calendarsInLandscape.clear();
        String url = "https://ta.skidor.com/EventCalendar.aspx?orgid=80";
        try {
            Document doc = Jsoup.connect(url).get();

            // Fetch the select element that contains the district information
            Element districtSelect = doc.getElementById("ctl00_MainRegion_CalendarList1_DropDownListDistrict");
            // Get the selected option's text
            String selectedDistrict = districtSelect.select("option[selected]").text();

            // Check if the selected district is "Ångermanlands Skidförbund"
            if ("Jämtland-Härjedalens Skidförbund".equals(selectedDistrict)) {
                Element table = doc.getElementById("ctl00_MainRegion_CalendarList1_ListViewEvents_itemPlaceholderContainer");
                Elements rows = table.select("tr.even, tr.odd");

                for (Element row : rows) {
                    Elements cells = row.select("td");
                    if (cells.size() > 5) {
                        String sixthCell = cells.get(5).text();
                        if ("Alpint".equals(sixthCell)) {
                            String secondCell = cells.get(1).text();
                            String thirdCell = cells.get(2).text();

                            CompetitionsInLandscape calendarInLandscape = new CompetitionsInLandscape();
                            calendarInLandscape.setDate(secondCell);
                            calendarInLandscape.setEvent(thirdCell);

                            calendarsInLandscape.add(calendarInLandscape);
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<CompetitionsInLandscape> getCalendarsInLandscape() {
        return calendarsInLandscape;
    }
}
