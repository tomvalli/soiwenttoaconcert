package org.tom_v_squad.soiwenttoaconcert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tom_v_squad.soiwenttoaconcert.data.EventRepository;
import org.tom_v_squad.soiwenttoaconcert.data.UserRepository;

@Controller
//@RequestMapping("index")
public class UserController {

    @Autowired
    private EventRepository eventRepository;

//    @RequestMapping("{events}")
//      @RequestMapping("index")
@RequestMapping("")
//    public String displayEventList(Model model) {
public String index(Model model) {
        model.addAttribute("event", "My Events");
        model.addAttribute("events", eventRepository.findAll());
        return "index";
    }
}
