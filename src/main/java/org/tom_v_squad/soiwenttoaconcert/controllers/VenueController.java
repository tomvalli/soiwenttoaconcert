package org.tom_v_squad.soiwenttoaconcert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.tom_v_squad.soiwenttoaconcert.data.VenueRepository;
import org.tom_v_squad.soiwenttoaconcert.models.Venue;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("venues")
public class VenueController {

   @Autowired
   private VenueRepository venueRepository;

   @RequestMapping("")
   public String index(Model model) {
      model.addAttribute("title", "Venues");
      model.addAttribute("venues", venueRepository.findAll());

      return "Venue/index";
   }


   @GetMapping("create")
   public String displayAddVenue(Model model) {
      model.addAttribute(new Venue());
      return "Venue/create";
   }

   @PostMapping("create")
   public String addVenue(@ModelAttribute @Valid Venue newVenue,
                                     Errors errors, Model model) {

      if (errors.hasErrors()) {
         return "Venue/create";
      }
      venueRepository.save(newVenue);
      return "redirect:";
   }

   @GetMapping("view/{venueId}")
   public String displayVenue(Model model, @PathVariable int venueId) {

      Optional optVenue = venueRepository.findById(venueId);
      if (optVenue.isPresent()) {
         Venue venue = (Venue) optVenue.get();
         model.addAttribute("venue", venue);
         return "Venue/index";
      } else {
         return "redirect:../";
      }
   }


}
