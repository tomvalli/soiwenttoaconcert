package org.tom_v_squad.soiwenttoaconcert.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private int eventId;

    private String name;
    private String location;
    private String date;
    private boolean festival;
    private int venueId;

    public Event(int eventId, String name, String location, String date, boolean festival, int venueId) {
        this.eventId = eventId;
        this.name = name;
        this.location = location;
        this.date = date;
        this.festival = festival;
        this.venueId = venueId;
    }

    public Event() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isFestival() {
        return festival;
    }

    public void setFestival(boolean festival) {
        this.festival = festival;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public int getEventId() {
        return eventId;
    }

    @Override
    public String toString() {
        return name;
    }

    //Generate Hash / Equals???

}
