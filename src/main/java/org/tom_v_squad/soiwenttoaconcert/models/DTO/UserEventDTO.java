package org.tom_v_squad.soiwenttoaconcert.models.DTO;

import com.sun.istack.NotNull;
import org.tom_v_squad.soiwenttoaconcert.models.Event;
import org.tom_v_squad.soiwenttoaconcert.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserEventDTO {

    @NotNull
    private User user;

    @NotNull
    private List<Event> events = new ArrayList<Event>();

    public UserEventDTO() {}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}

