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
import org.tom_v_squad.soiwenttoaconcert.models.Event;
import org.tom_v_squad.soiwenttoaconcert.models.Venue;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("venue")
public class VenueController {

   @Autowired
   private VenueRepository venueRepository;

   @Autowired
   private EventRepository eventRepository;

   @Autowired
   private UserRepository userRepository;

   @Autowired
   private ArtistRepository artistRepository;

   private static List<Venue> venues = new ArrayList<>();

   @RequestMapping("")
   public String displayVenues(Model model) {
      model.addAttribute("title", "Venues");
      model.addAttribute("venues", venueRepository.findAll());

      return "venue/index";
   }


   @GetMapping("create")
   public String displayAddVenue(Model model) {
      model.addAttribute(new Venue());
      return "venue/create";
   }

   @PostMapping("create")
   public String processAddVenueForm(@ModelAttribute @Valid Venue newVenue, Errors errors, Model model) {

      if (errors.hasErrors()) {
         return "venue/create";
      }
      venueRepository.save(newVenue);
      return "redirect:/venue";
   }

   @GetMapping("delete")
   public String displayDeleteVenueForm(@RequestParam Integer venueId, Model model) {
      Optional<Venue> result = venueRepository.findById(venueId);
      System.out.println(venueId);
      if (!result.isEmpty()) {
         Venue venue = result.get();
         model.addAttribute("title","Delete Artist");
         model.addAttribute("venue", venue);
         return "venue/delete";
      }else{
         model.addAttribute("title", "Invalid Venue ID: " + venueId);
      }
      return "venue/delete";
   }

   @PostMapping("delete")
   public String processDeleteVenueForm(@RequestParam(required = false) Integer venueId) {

      if (venueId != null) {
         Optional<Venue> result = venueRepository.findById(venueId);
         if (result.isPresent()) {
            venueRepository.delete(result.get());
         }
      }
      return "redirect:";
   }
   @GetMapping("edit")
   public String displayEditVenueForm(@RequestParam Integer venueId, Model model) {
      Optional <Venue> result = venueRepository.findById(venueId);

      if (result.isEmpty()) {
         model.addAttribute("title", "Invalid Venue ID: " + venueId);
      } else {
         Venue venue = result.get();
         model.addAttribute("venue", venue);
      }
      return "venue/edit";
   }

   @PostMapping("edit")
   public String processEditVenueForm(@RequestParam Integer venueId, @ModelAttribute Venue newVenue, Errors errors, Model model) {
      if(errors.hasErrors()) {
         model.addAttribute("title", "Create Venue");
         return "venue/create";
      }
      venueRepository.save(newVenue);
      venueRepository.deleteById(venueId);
      return "redirect:";
   }


}
