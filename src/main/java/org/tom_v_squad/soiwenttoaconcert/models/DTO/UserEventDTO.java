package org.tom_v_squad.soiwenttoaconcert.models.DTO;

import com.sun.istack.NotNull;
import org.tom_v_squad.soiwenttoaconcert.models.Event;
import org.tom_v_squad.soiwenttoaconcert.models.User;

public class EventUserDTO {

    @NotNull
    private Event event;

    @NotNull
    private User user;

    public EventUserDTO() {}

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
