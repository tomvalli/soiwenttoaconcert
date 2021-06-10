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

    ///// constructors
    public Profile() {}

    public Profile(String profileLocation) {
        this.profileLocation = profileLocation;

    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return profileId == profile.profileId;
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(profileId);
//    }
//
//    public int getProfileId() {
//        return profileId;
//    }
//
//    public void setProfileId(int profileId) {
//        this.profileId = profileId;
//    }

    public String profileLocation() {
        return profileLocation;
    }

    public void setProfileLocation(String profileLocation) {
        this.profileLocation = profileLocation;
    }

    public int getProfileId() {
        return profileId;
    }

    public String getProfileLocation() {
        return profileLocation;
    }

    public String getProfileBiography() {
        return profileBiography;
    }
}

