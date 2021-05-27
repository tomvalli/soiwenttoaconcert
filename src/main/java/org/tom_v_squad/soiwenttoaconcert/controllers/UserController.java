package org.tom_v_squad.soiwenttoaconcert.controllers;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.tom_v_squad.soiwenttoaconcert.data.EventRepository;
import org.tom_v_squad.soiwenttoaconcert.data.UserRepository;
import org.tom_v_squad.soiwenttoaconcert.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    private static final String userSessionKey = "user";

    private static final String event = "event";



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


    @GetMapping("/")
    public String displayWelcomeName(HttpServletRequest request, Model model) {
        //give user's name from login/session to user artists template
        User user = getUserFromSession(request.getSession());
        String username = user.getUsername();
        model.addAttribute("greeting", username);
        //give list of all events to user artists template
        model.addAttribute("event", "List Event");
        model.addAttribute("events", eventRepository.findAll());
        return "index";

    }
}
