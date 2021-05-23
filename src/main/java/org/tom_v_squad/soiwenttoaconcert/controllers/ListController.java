package org.tom_v_squad.soiwenttoaconcert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.tom_v_squad.soiwenttoaconcert.data.ArtistRepository;
import org.tom_v_squad.soiwenttoaconcert.data.EventRepository;
import org.tom_v_squad.soiwenttoaconcert.data.VenueRepository;
import org.tom_v_squad.soiwenttoaconcert.models.Event;
import org.tom_v_squad.soiwenttoaconcert.models.EventData;

import java.util.HashMap;

@Controller
@RequestMapping(value = "list")
public class ListController {

    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ArtistRepository artistRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController () {
    columnChoices.put("venues", "Venues");
    columnChoices.put("events", "Events");
    columnChoices.put("artists", "Artists");
    }

    @RequestMapping("")
    public String list (Model model){
        model.addAttribute("venues", venueRepository.findAll());
        model.addAttribute("artists", artistRepository.findAll());
        model.addAttribute("events", "Events");

        return "list";
    }

    @RequestMapping(value = "jobs")
    public String listResults(Model model, @RequestParam String column, @RequestParam String value){

        Iterable<Event> events;
        if (column.toLowerCase().equals("all")){
            events = eventRepository.findAll();
            model.addAttribute("events", "Events");
        } else {
            events = EventData.findByColumnAndValue(column, value, eventRepository.findAll());
            model.addAttribute("title", "Events with " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("events", events);

        return "list-events";
    }
}
