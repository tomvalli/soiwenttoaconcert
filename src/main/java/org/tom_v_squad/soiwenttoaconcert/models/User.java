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

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);
    }

    public User(String username, String userBiography, String userLocation ) {
        this.username = username;
        this.userBiography = userBiography;
        this.userLocation = userLocation;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) { this.username = username; }

    public List<Event> getEvents() {
        return events;
    }

    public void addEvent(Event event) {
        this.events.add(event);
    }

    public String getUserLocation() { return userLocation; }

    public void setUserLocation(String userLocation) { this.userLocation = userLocation; }

    public String getUserBiography() { return userBiography; }

    public void setUserBiography(String userBiography) { this.userBiography = userBiography; }

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }
}
