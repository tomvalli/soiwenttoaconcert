package org.tom_v_squad.soiwenttoaconcert.models;

public class Venue {
    private String name;
    private String location;


    public Venue(String aName, String aLocation) {
        this.name = aName;
        this.location = aLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
