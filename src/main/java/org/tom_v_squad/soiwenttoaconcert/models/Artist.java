package org.tom_v_squad.soiwenttoaconcert.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @NotBlank(message = "Please enter artist name.")
    private String artistName;
    @NotBlank(message = "Enter artist's genre.")
    private String artistGenre;

    @OneToMany
    @JoinColumn
    private final List<Event> events = new ArrayList<>();

    public Artist(int artistId, String artistName, String artistGenre){
        this.artistId = artistId;
        this.artistName = artistName;
        this.artistGenre = artistGenre;
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

    public String getArtistGenre() {
        return artistGenre;
    }

    public void setArtistGenre(String artistGenre) {
        this.artistGenre = artistGenre;
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
        return artistId == artist.artistId && artistName.equals(artist.artistName) && artistGenre.equals(artist.artistGenre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artistId, artistName, artistGenre);
    }
}
