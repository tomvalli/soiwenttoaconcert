package org.tom_v_squad.soiwenttoaconcert.models;

import org.hibernate.mapping.List;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Objects;

//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
@Entity
public class Profile {

    ///// variables

    @Id
    @GeneratedValue
    private int profileId;

    private String profileLocation;
    private String profileBiography;

//    @OneToOne(mappedBy = "profile")
//    private final List<User> users = new ArrayList<>();

    ///// constructors

    public Profile(int profileId, String profileLocation, String profileBiography) {
        this.profileId = profileId;
        this.profileLocation = profileLocation;
        this.profileBiography = profileBiography;
    }

    public Profile() {}

    ///// Methods & Overrides


    public int getProfileId() {
        return profileId;
    }

    public String getProfileLocation() {
        return profileLocation;
    }

    public void setProfileLocation(String profileLocation) {
        this.profileLocation = profileLocation;
    }

    public String getProfileBiography() {
        return profileBiography;
    }

    public void setProfileBiography(String profileBiography) {
        this.profileBiography = profileBiography;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return profileId == profile.profileId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(profileId);
    }

}

