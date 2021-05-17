package org.tom_v_squad.soiwenttoaconcert.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Venue {

    @Id
    @GeneratedValue
    private int venueId;

    private String venueName;
    private String venueLocation;



    public Venue(int venueId, String venueName, String venueLocation) {
        this.venueId = venueId;
        this.venueName = venueName;
        this.venueLocation = venueLocation;
    }

    public Venue(){}

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueLocation() {
        return venueLocation;
    }

    public void setVenueLocation(String venueLocation) {
        this.venueLocation = venueLocation;
    }

    public int getVenueId() {
        return venueId;
    }

    @Override
    public String toString() {
        return venueName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venue venue = (Venue) o;
        return venueId == venue.venueId && venueName.equals(venue.venueName) && venueLocation.equals(venue.venueLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(venueId, venueName, venueLocation);
    }
}
