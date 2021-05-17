package org.tom_v_squad.soiwenttoaconcert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.tom_v_squad.soiwenttoaconcert.data.ArtistRepository;
import org.tom_v_squad.soiwenttoaconcert.models.Artist;
import org.tom_v_squad.soiwenttoaconcert.models.Venue;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("artists")
public class ArtistController {

    @Autowired
    private ArtistRepository artistRepository;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Artists");
        model.addAttribute("artists", artistRepository.findAll());

        return "Artist/index";
    }

    @GetMapping("create")
    public String displayAddArtist(Model model) {
        model.addAttribute(new Artist());
        return "Artist/create";
    }

    @PostMapping("create")
    public String addVenue(@ModelAttribute @Valid Artist newArtist,
                           Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "Artist/create";
        }
        artistRepository.save(newArtist);
        return "redirect:";
    }

    @GetMapping("view/{artistId}")
    public String displayVenue(Model model, @PathVariable int artistId) {

        Optional optArtist = artistRepository.findById(artistId);
        if (optArtist.isPresent()) {
            Artist artist = (Artist) optArtist.get();
            model.addAttribute("artist", artist);
            return "Artist/index";
        } else {
            return "redirect:../";
        }

    }
}
