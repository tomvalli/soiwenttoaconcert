package org.tom_v_squad.soiwenttoaconcert.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tom_v_squad.soiwenttoaconcert.models.Event;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    private static List<Event> events = new ArrayList<>();

    @GetMapping("create")
    public String createEventForm(Model model) {
    model.addAttribute("title", "Create Event");
    model.addAttribute(new Event());
    return "events/create";
}

    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute Event newEvent,
                                         Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Event");
            return "events/create";
        }

        events.add(new Event());
        return "events/create";
    }


}
