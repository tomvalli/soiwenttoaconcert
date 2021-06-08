package org.tom_v_squad.soiwenttoaconcert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.tom_v_squad.soiwenttoaconcert.data.ArtistRepository;
import org.tom_v_squad.soiwenttoaconcert.data.EventRepository;
import org.tom_v_squad.soiwenttoaconcert.data.UserRepository;
import org.tom_v_squad.soiwenttoaconcert.data.VenueRepository;
import org.tom_v_squad.soiwenttoaconcert.models.Event;
import org.tom_v_squad.soiwenttoaconcert.models.EventData;

import static org.tom_v_squad.soiwenttoaconcert.controllers.ListController.columnChoices;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private VenueRepository venueRepository;

    @RequestMapping("")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
        Iterable<Event> events;
        if (searchTerm.toLowerCase().equals("all") || searchTerm.toLowerCase().equals("")){
            events = eventRepository.findAll();

        } else {

            events = EventData.findByColumnAndValue(searchType, searchTerm, eventRepository.findAll());
            //events = EventData.findByValue(searchTerm, events);
        }
        model.addAttribute("columns", columnChoices);
        model.addAttribute("title", "Events with " + columnChoices.get(searchType) + ": " + searchTerm);
        model.addAttribute("events", events);

        return "search";
    }




}
