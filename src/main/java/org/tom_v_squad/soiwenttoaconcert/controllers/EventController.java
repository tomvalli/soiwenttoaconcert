package org.tom_v_squad.soiwenttoaconcert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.tom_v_squad.soiwenttoaconcert.data.EventRepository;
import org.tom_v_squad.soiwenttoaconcert.models.Event;

import java.util.Optional;

@Controller
@RequestMapping("events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
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
        eventRepository.save(newEvent);
        return "events/create";
    }

    @GetMapping("index")
    public String displayEventList(Model model) {
        model.addAttribute("event","List Event");
        model.addAttribute("events", eventRepository.findAll());
        return "events/index";
    }

    @GetMapping("edit")
    public String displayEditEventForm(@RequestParam Integer eventId, Model model) {
        Optional <Event> result = eventRepository.findById(eventId);

        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid Event ID: " + eventId);
        } else {
            Event event = result.get();
            model.addAttribute("event", event);
        }
        return "/events/edit";
    }

    @PostMapping("edit")
    public String processEditEventForm(@RequestParam Integer eventId, @ModelAttribute Event newEvent, Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Event");
            return "events/create";
        }
        eventRepository.save(newEvent);
        eventRepository.deleteById(eventId);
        return "redirect:/events/index";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(@RequestParam Integer eventId, Model model) {
        Optional<Event> result = eventRepository.findById(eventId);

        if (!result.isEmpty()) {
            Event event = result.get();
            model.addAttribute("title","Delete Event");
            model.addAttribute("event", event);
            return "events/delete";
        }else{
            model.addAttribute("title", "Invalid Event ID: " + eventId);
        }
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) Integer eventId) {

        if (eventId != null) {
                Optional<Event> result = eventRepository.findById(eventId);
                if (result.isPresent()) {
                eventRepository.delete(result.get());
            }
        }
        return "redirect:/events/index";
    }

}
