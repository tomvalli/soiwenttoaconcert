package org.tom_v_squad.soiwenttoaconcert.models.DTO;

import com.sun.istack.NotNull;
import org.tom_v_squad.soiwenttoaconcert.models.Event;
import org.tom_v_squad.soiwenttoaconcert.models.User;

public class UserEventDTO {

    @NotNull
    private User user;

    @NotNull
    private Event event;

    public UserEventDTO() {}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

}

