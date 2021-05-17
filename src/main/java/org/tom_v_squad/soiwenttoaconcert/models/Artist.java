package org.tom_v_squad.soiwenttoaconcert.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Artist {

//    @ManyToMany(mappedBy = "artists")
//    private List<Event> events = new ArrayList<>();

    @Id
    @GeneratedValue
    private int artistId;

    private String artistName;

    public Artist(int artistId, String artistName){
        this.artistId = artistId;
        this.artistName = artistName;
    }
    public Artist(){}

    public int getArtistId() {
        return artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    @Override
    public String toString() {
        return artistName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return artistId == artist.artistId && artistName.equals(artist.artistName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artistId, artistName);
    }
}
