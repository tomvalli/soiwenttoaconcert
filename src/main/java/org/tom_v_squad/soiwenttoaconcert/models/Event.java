package org.tom_v_squad.soiwenttoaconcert.models;

public class Event {

    private String name;

    public Event() { }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
