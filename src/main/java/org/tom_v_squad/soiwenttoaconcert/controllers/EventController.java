package org.tom_v_squad.soiwenttoaconcert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tom_v_squad.soiwenttoaconcert.data.ArtistRepository;
import org.tom_v_squad.soiwenttoaconcert.data.EventRepository;
import org.tom_v_squad.soiwenttoaconcert.data.UserRepository;
import org.tom_v_squad.soiwenttoaconcert.data.VenueRepository;
import org.tom_v_squad.soiwenttoaconcert.models.DTO.UserEventDTO;
import org.tom_v_squad.soiwenttoaconcert.models.Event;
import org.tom_v_squad.soiwenttoaconcert.models.User;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private VenueRepository venueRepository;

    @GetMapping("create")
    public String createEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event());
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute Event newEvent,
                                         Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Event");
            return "events/create";
        }

        eventRepository.save(newEvent);
        return "events/create";
    }

    @GetMapping("index")
    public String displayEventList(HttpSession session, Model model) {

        Integer userId = (Integer) session.getAttribute("user");
        Optional<User> result = userRepository.findById(userId);
        User user = result.get();

        model.addAttribute("event","List Event");
        model.addAttribute("events", eventRepository.findAll());
        model.addAttribute("attendedEvents", user.getEvents());

        return "events/index";
    }

    @GetMapping("select")
    public String selectEvents(HttpSession session, Model model) {

        Integer userId = (Integer) session.getAttribute("user");
        Optional<User> result = userRepository.findById(userId);
        User user = result.get();

        List<Event> existingEvents = (List<Event>) eventRepository.findAll();
        List<Event> attendedEvents = user.getEvents();

        existingEvents.removeAll(attendedEvents);

        model.addAttribute("event","List Event");
        model.addAttribute("events", existingEvents);
        model.addAttribute("empty", false);

        if (existingEvents.size() == 0) {
            model.addAttribute("empty", true);
        }

        UserEventDTO userEvent = new UserEventDTO();
        userEvent.setUser(user);

        model.addAttribute("userEvent", userEvent);
        return "events/select";
    }

    @PostMapping("select")
    public String selectEvents(@ModelAttribute @Valid UserEventDTO userEvent,
                               Errors errors,
                               Model model) {

        User user = userEvent.getUser();
        List<Event> selectedEvents = userEvent.getEvents();

        if (!errors.hasErrors()) {
            for (Event selectedEvent : selectedEvents) {
                if (!user.getEvents().contains(selectedEvent)) {
                    user.addEvent(selectedEvent);
                    userRepository.save(user);
                }
            }
        }

        return "redirect:/events/index";
    }

}
