package org.tom_v_squad.soiwenttoaconcert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.tom_v_squad.soiwenttoaconcert.data.ArtistRepository;
import org.tom_v_squad.soiwenttoaconcert.data.EventRepository;
import org.tom_v_squad.soiwenttoaconcert.data.UserRepository;
import org.tom_v_squad.soiwenttoaconcert.data.VenueRepository;
import org.tom_v_squad.soiwenttoaconcert.models.Artist;
import org.tom_v_squad.soiwenttoaconcert.models.EventData;
import org.tom_v_squad.soiwenttoaconcert.models.Venue;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("artist")
public class ArtistController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private VenueRepository venueRepository;

    @RequestMapping("")
    public String displayArtists(Model model) {
        model.addAttribute("title", "Artists");
        model.addAttribute("artists", artistRepository.findAll());

        return "artist/index";
    }

    @GetMapping("create")
    public String displayAddArtist(Model model) {
        model.addAttribute(new Artist());
        return "artist/create";
    }

    @PostMapping("create")
    public String processAddArtistForm(@ModelAttribute @Valid Artist newArtist,
                           Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "artist/create";
        }
        artistRepository.save(newArtist);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteArtistForm(@RequestParam Integer artistId, Model model) {
        Optional<Artist> result = artistRepository.findById(artistId);
        System.out.println(artistId);
        if (!result.isEmpty()) {
            Artist artist = result.get();
            model.addAttribute("title","Delete Artist");
            model.addAttribute("artist", artist);
            return "artist/delete";
        }else{
            model.addAttribute("title", "Invalid Event ID: " + artistId);
        }
        return "artist/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) Integer artistId) {

        if (artistId != null) {
            Optional<Artist> result = artistRepository.findById(artistId);
            if (result.isPresent()) {
                artistRepository.delete(result.get());
            }
        }
        return "redirect:";
    }
    @GetMapping("edit")
    public String displayEditArtistForm(@RequestParam Integer artistId, Model model) {
        Optional <Artist> result = artistRepository.findById(artistId);

        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid Event ID: " + artistId);
        } else {
            Artist artist = result.get();
            model.addAttribute("artist", artist);
        }
        return "artist/edit";
    }

    @PostMapping("edit")
    public String processEditArtistForm(@RequestParam Integer artistId, @ModelAttribute Artist newArtist, Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Event");
            return "artist/create";
        }
        artistRepository.save(newArtist);
        artistRepository.deleteById(artistId);
        return "redirect:";
    }
}
