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

    @Column(name = "organizer_c")
    private String organizer;

    public CompetitionCalendar(){

    }

    public CompetitionCalendar(String date, String event, String organizer) {
        this.date = date;
        this.event = event;
        this.organizer = organizer;
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
    public void setDate(String title) {
        this.date = date;
    }
    public String getEvent() {
        return event;
    }
    public void setEvent(String text) {
        this.event = event;
    }
    public String getOrganizer() {return organizer;}
    public void setOrganizer(String organizer) {this.organizer = organizer;}
}
