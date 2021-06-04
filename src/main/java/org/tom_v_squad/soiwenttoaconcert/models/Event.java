package org.tom_v_squad.soiwenttoaconcert.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
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

    @OneToOne(cascade = CascadeType.ALL)
    private Venue venue;
    private String genre;

    @ManyToMany(mappedBy = "events")
    private final List<User> users = new ArrayList<>();

    public Event(int eventId, String artistName, String location, String date, boolean festival, Venue venue, String genre) {
        this.eventId = eventId;
        this.artistName = artistName;
        this.location = location;
        this.date = date;
        this.festival = festival;
        this.venue = venue;
        this.genre = genre;

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


    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public int getEventId() {
        return eventId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return artistName;
    }

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
