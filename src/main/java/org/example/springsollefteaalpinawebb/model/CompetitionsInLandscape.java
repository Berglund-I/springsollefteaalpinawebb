package org.example.springsollefteaalpinawebb.model;

import jakarta.persistence.*;

@Entity
@Table(name = "competitionsInLandscape")
public class CompetitionsInLandscape {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date_c")
    private String date;

    @Column(name = "event_c")
    private String event;

    public CompetitionsInLandscape(){

    }

    public CompetitionsInLandscape(String date, String event) {
        this.date = date;
        this.event = event;
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
}
