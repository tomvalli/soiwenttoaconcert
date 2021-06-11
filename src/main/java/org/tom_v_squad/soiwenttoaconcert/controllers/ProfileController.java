package org.tom_v_squad.soiwenttoaconcert.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.tom_v_squad.soiwenttoaconcert.data.ProfileRepository;
import org.tom_v_squad.soiwenttoaconcert.data.UserRepository;
import org.tom_v_squad.soiwenttoaconcert.models.Event;
import org.tom_v_squad.soiwenttoaconcert.models.Profile;
import org.tom_v_squad.soiwenttoaconcert.models.User;

import javax.servlet.http.HttpSession;
import java.util.Map;
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
        System.out.println("############### goUpdate()");
        Integer userId = (Integer) session.getAttribute("user");
        Optional<User> result = userRepository.findById(userId);
        User user = result.get();
        if(user.getProfile()==null) {
            user.setProfile(new Profile());
            // need to po
        }
        model.addAttribute("users_name", user.getUsername());
        model.addAttribute("profile", user.getProfile());
        return "profile/update";

    }

    @PostMapping(path="/update", consumes = "application/x-www-form-urlencoded")
    public String sendUpdate(@RequestParam Map<String, String> body,
                             HttpSession session,
                             Model model) {
        System.out.println("############### sendUpdate()" + body);
        Profile profile = new Profile(body.get("profileLocation"), body.get("profileBiography"));
        profileRepository.save(profile);
        model.addAttribute("profile", profile);

        Integer userId = (Integer) session.getAttribute("user");
        Optional<User> result = userRepository.findById(userId);
        User user = result.get();
        user.setProfile(profile);
        userRepository.save(user);

//        model.addAttribute(new Profile());
        return displayUserProfile(session, model);
    }

    @GetMapping("index")
    public String displayUserProfile(HttpSession session, Model model) {
        System.out.println("############### displayUserProfile()");

        Integer userId = (Integer) session.getAttribute("user");
        Optional<User> result = userRepository.findById(userId);
        User user = result.get();
        if(user.getProfile() == null) {
            user.setProfile(new Profile());
        }
        model.addAttribute("users_name", user.getUsername());
        model.addAttribute("profile", user.getProfile());

        return "profile/index";
    }
}