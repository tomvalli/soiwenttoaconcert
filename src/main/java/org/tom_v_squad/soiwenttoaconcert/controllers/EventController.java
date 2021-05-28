package org.tom_v_squad.soiwenttoaconcert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.tom_v_squad.soiwenttoaconcert.data.EventRepository;
import org.tom_v_squad.soiwenttoaconcert.models.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

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

        eventRepository.save(newEvent);
        return "events/create";
    }

    @GetMapping("index")
    public String displayEventList(Model model) {
        model.addAttribute("event","List Event");
        model.addAttribute("events", eventRepository.findAll());
        return "events/index";
    }

    @GetMapping("edit/{eventId}")
    public String editEventForm(@PathVariable Integer eventId, Model model) {
        Optional<Event> result = eventRepository.findById(eventId);

        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid Event ID: " + eventId);
        }else{
            Event event = result.get();
            //System.out.println(event.getEventId());
            model.addAttribute("event", event);
        }

        return "events/edit";

    }

    @PostMapping("edit/{eventId}")
    public String editEventForm(@PathVariable Integer eventId, @ModelAttribute Event newEvent, Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Event");
            return "events/create";
        }
       // model.addAttribute("location", location);
        eventRepository.save(newEvent);
        return "events/index";
    }

    @GetMapping("delete/{eventId}")
//    @GetMapping("delete")
    public String displayDeleteEventForm(@RequestParam Integer eventId, Model model) {
//        Optional<Event> result = eventRepository.findById(eventId);
////attach a collection of events to loop thru + display
//        if (!result.isEmpty()) {
//            Event event = result.get();
//            model.addAttribute("title","Delete Event");
//            model.addAttribute("event", event);
//            return "events/delete";
//
//        }else{
//            model.addAttribute("title", "Invalid Event ID: " + eventId);
//        }

        return "events/delete";

    }

//    @GetMapping("delete")
//    public String renderDeleteEventForm(Model model) {
//        model.addAttribute("title", "Delete Event");
//        model.addAttribute("events", eventRepository.findAll());
//        return "events/delete";
//    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) Integer eventId) {

        if (eventId != null) {
                Optional<Event> result = eventRepository.findById(eventId);
                eventRepository.delete(result.get());
        }

        return "redirect:";
    }

//    @PostMapping("/delete/{eventId}")
//    public String processDeleteEventForm(@PathVariable Integer eventId, Model model) {
//        Optional<Event> result = eventRepository.findById(eventId);
//        if (result.isEmpty()) {
//            model.addAttribute("title", "Invalid Event ID: " + eventId);
//        }else {
//            Event event = result.get();
//            //model.addAttribute("event", result);
//            eventRepository.delete(event);
//        }
//        return "redirect:/events/index";
//        //IDK what is happening here, should "event" be "result"?
//    }
}
