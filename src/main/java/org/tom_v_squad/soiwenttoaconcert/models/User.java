package org.tom_v_squad.soiwenttoaconcert.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.*;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    @ManyToMany
    private final List<Event> events = new ArrayList<Event>();

    private String userLocation;

    private String userBiography;

    ///////////////////

    public User() {}

    public User(String username, String password, String userLocation, String userBiography) {
        this.username = username;
        this.pwHash = encoder.encode(password);
        this.userLocation = userLocation;
        this.userBiography = userBiography;
    }


    ///////////////////

    public int getId() {
        return id;
    }

    ///////////////////

    public String getUsername() {
        return username;
    }
    // ek addition
    public void setUsername(String username) { this.username = username; }

    ///////////////////

    public List<Event> getEvents() {
        return events;
    }

    public void addEvent(Event event) {
        this.events.add(event);
    }

    ///////////////////

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    ///////////////////

    public String getUserLocation() { return userLocation; }

    public void setUserLocation(String userLocation) { this.userLocation = userLocation; }

    ///////////////////

    public String getUserBiography() { return userBiography; }

    public void setUserBiography(String userBiography) { this.userBiography = userBiography; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() && getUsername().equals(user.getUsername()) && pwHash.equals(user.pwHash) && Objects.equals(getEvents(), user.getEvents()) && Objects.equals(getUserLocation(), user.getUserLocation()) && Objects.equals(getUserBiography(), user.getUserBiography());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
