package org.tom_v_squad.soiwenttoaconcert.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private int eventId;

    private String artistName;
    private String location;
    private String date;
    private boolean festival;
    private int venueId;

    public Event(int eventId, String artistName, String location, String date, boolean festival, int venueId) {
        this.eventId = eventId;
        this.artistName = artistName;
        this.location = location;
        this.date = date;
        this.festival = festival;
        this.venueId = venueId;
    }

    public Event() { }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
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
        return artistName;
    }

    //Generate Hash / Equals??? 17.5.2.2


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return eventId == event.eventId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId);
    }
}
