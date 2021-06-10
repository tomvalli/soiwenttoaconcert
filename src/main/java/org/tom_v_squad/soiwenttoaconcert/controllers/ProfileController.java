package org.tom_v_squad.soiwenttoaconcert.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tom_v_squad.soiwenttoaconcert.data.ProfileRepository;
import org.tom_v_squad.soiwenttoaconcert.data.UserRepository;
import org.tom_v_squad.soiwenttoaconcert.models.Event;
import org.tom_v_squad.soiwenttoaconcert.models.Greeting;
import org.tom_v_squad.soiwenttoaconcert.models.Profile;
import org.tom_v_squad.soiwenttoaconcert.models.User;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("profile")
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("update")
    public String goUpdate(HttpSession session, Model model) {
        Integer userId = (Integer) session.getAttribute("user");
        Optional<User> result = userRepository.findById(userId);
        User user = result.get();
        Optional<Profile> profileResult = profileRepository.findById(user.getProfile().getProfileId());
        model.addAttribute("users_name", user.getUsername());
        model.addAttribute("profile", user.getProfile());
        return "profile/update";
    }

    @PostMapping("update")
    public String sendUpdate(@ModelAttribute Profile profile, Model model) {

        model.addAttribute("profile", profile);
        model.addAttribute(new Profile());
        return "profile/update";
    }

    @GetMapping("index")
    public String displayUserProfile(HttpSession session, Model model) {

        Integer userId = (Integer) session.getAttribute("user");
        Optional<User> result = userRepository.findById(userId);
        User user = result.get();
        Optional<Profile> profileResult = profileRepository.findById(user.getProfile().getProfileId());
        model.addAttribute("users_name", user.getUsername());
        model.addAttribute("profile", user.getProfile());

        return "profile/index";
    }
}