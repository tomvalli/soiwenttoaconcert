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
        System.out.println("@@@@@@@@@@@@");
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

    @PostMapping(path="/update")
    public String sendUpdate(@RequestBody Profile profile, Model model) {
        System.out.println("#########");
        profileRepository.save(profile);
        model.addAttribute("profile", profile);
//        model.addAttribute(new Profile());
        return "profile/update";
    }

    @GetMapping("index")
    public String displayUserProfile(HttpSession session, Model model) {

        Integer userId = (Integer) session.getAttribute("user");
        Optional<User> result = userRepository.findById(userId);
        User user = result.get();
        Optional<Profile> profileResult = profileRepository.findById(user.getProfile().getProfileId());
        if(profileResult==null) {
            System.out.println("null@@@@@@@@@@@@");
        } else
        model.addAttribute("users_name", user.getUsername());
        model.addAttribute("profile", user.getProfile());

        return "profile/index";
    }
}