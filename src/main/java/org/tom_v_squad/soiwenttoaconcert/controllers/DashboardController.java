package org.tom_v_squad.soiwenttoaconcert.controllers;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.tom_v_squad.soiwenttoaconcert.controllers.ProfileController;
import org.tom_v_squad.soiwenttoaconcert.data.EventRepository;
import org.tom_v_squad.soiwenttoaconcert.data.UserRepository;
import org.tom_v_squad.soiwenttoaconcert.models.User;

import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;


@Controller
//@Entity
public class DashboardController {


    @Autowired
    private EventRepository eventRepository;

    private static final String event = "event";

     @Autowired
     private UserRepository userRepository;

     private static final String userSessionKey = "user";


//    @Override
//    public displayMyProfile(HttpServletRequest request, Model model) {
//        super(request, model);
//    }

//    @Override
//    public displayUpdateMyProfile(HttpSession session) {
//        super(session);
//        return;
//    }

     public User getUserFromSession(HttpSession session) {
         Integer userId = (Integer) session.getAttribute(userSessionKey);
         if (userId == null) {
             return null;
         }
         Optional<User> user = userRepository.findById(userId);
         if (user.isEmpty()) {
             return null;
         }
         return user.get();
     }
     public void setUserRepository(UserRepository userRepository) {
         this.userRepository = userRepository;
     }

    @GetMapping("/")
    public String displayDashboard(HttpServletRequest request, Model model) {
            //give user's name from login/session to user profile template
        User user = getUserFromSession(request.getSession());
        String username = user.getUsername();
        model.addAttribute("greeting", username);
            //give list of all events to user profile template
//        model.addAttribute("artist");
        model.addAttribute("event", "List Event");
        model.addAttribute("events", eventRepository.findAll());
        return "index";
    }

//    @GetMapping("/")
//    public String displayDashboard(Model model) {
//
//        return "index";
//    }
}
