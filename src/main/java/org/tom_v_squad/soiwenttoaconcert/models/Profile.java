package org.tom_v_squad.soiwenttoaconcert.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Profile {

    @Id
    @GeneratedValue
    @Column(name="profile_id")
    private int profileId;
    @Column(name="profile_location")
    private String profileLocation;
    @Column(name="profile_biography")
    private String profileBiography;

//    @OneToOne
//    private User user;

    ///// constructors
    public Profile(int profileId, String profileLocation, String profileBiography) {
        this.profileId = profileId;
        this.profileLocation = profileLocation;
        this.profileBiography = profileBiography;
    }

    public Profile(String profileLocation, String profileBiography) {
        this.profileLocation = profileLocation;
        this.profileBiography = profileBiography;
    }

    public Profile() {
        this.profileId = profileId++;
    }

    ///////  methods
    public int getProfileId() { return profileId; }

    public String getProfileLocation() {
        return profileLocation;
    }

    public void setProfileLocation(String profileLocation) {
        this.profileLocation = profileLocation;
    }

    public String getProfileBiography() {
        return profileBiography;
    }

//    public String profileLocation() {
//        return profileLocation;
//    }

//    public void setProfileBiography(String profileBiography) { this.profileBiography = profileBiography; }
// public Profile(String profileLocation) {
//        this.profileLocation = profileLocation;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return profileId == profile.profileId &&
                profileLocation.equals(profile.profileLocation) &&
                profileBiography.equals(profile.profileBiography);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profileId, profileLocation, profileBiography);
    }



}
