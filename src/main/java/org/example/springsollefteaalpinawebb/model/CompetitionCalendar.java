package org.example.springsollefteaalpinawebb.model;

import jakarta.persistence.*;

@Entity
@Table(name = "competitionCalendar")
public class CompetitionCalendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date_c")
    private String date;

    @Column(name = "event_c")
    private String event;

    @Column(name = "event_ID")
    private String eventID;

    public CompetitionCalendar(){

    }

    public CompetitionCalendar(String date, String event, String eventID) {
        this.date = date;
        this.event = event;
        this.eventID = eventID;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getEvent() {
        return event;
    }
    public void setEvent(String event) {
        this.event = event;
    }
    public String getEventID() { return eventID; }
    public void setEventID(String eventID) { this.eventID = eventID; }

}
