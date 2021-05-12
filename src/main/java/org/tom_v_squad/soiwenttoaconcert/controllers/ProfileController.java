package org.tom_v_squad.soiwenttoaconcert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tom_v_squad.soiwenttoaconcert.data.EventRepository;
import org.tom_v_squad.soiwenttoaconcert.data.UserRepository;
import org.tom_v_squad.soiwenttoaconcert.models.Event;
import org.tom_v_squad.soiwenttoaconcert.models.User;
import org.tom_v_squad.soiwenttoaconcert.controllers.UserController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("profile")
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    private static final String userSessionKey = "user";
    private User updateProfile;


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

    @GetMapping("profile")
    public String displayMyProfile(HttpServletRequest request, Model model) {
        User user = getUserFromSession(request.getSession());
        String username = user.getUsername();
        model.addAttribute("greeting", username);
        return "profile/index";
    }

        @PostMapping("edit")
        public String displayUpdateMyProfile(@ModelAttribute Event updateProfile,
                                                Errors errors, Model model) {
            if (errors.hasErrors()) {
                model.addAttribute("title", "Create Event");
            return "profile/edit";
        }
            userRepository.save(updateProfile);
            return "profile/edit";
    }
















    @GetMapping("edit")
    public String createProfileForm(Model model) {
        model.addAttribute("title", "Create Profile");
        model.addAttribute(new User());
        return "profile/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute Profile newProfile,
                                         Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Profile");
            return "profile/create";
        }

        User newUser = null;
        userRepository.save(newUser);
        return "profile/create";
    }

//    @GetMapping("index")
//    public String displayEventList(Model model) {
//        model.addAttribute("profile", "List Profile");
//        model.addAttribute("profiles", userRepository.findAll());
//        return "profile/index";
//    }

}
