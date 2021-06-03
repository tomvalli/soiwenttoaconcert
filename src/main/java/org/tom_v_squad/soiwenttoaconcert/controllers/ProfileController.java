package org.tom_v_squad.soiwenttoaconcert.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tom_v_squad.soiwenttoaconcert.data.ProfileRepository;
import org.tom_v_squad.soiwenttoaconcert.data.UserRepository;
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

    @GetMapping("view")
    public String goView() {
//        System.out.println("In Profile Controller");
        return "profile/view";
    }

    @GetMapping("update")
    public String goUpdate() {
//        System.out.println("In Profile Controller");
        return "profile/update";
    }

    @PostMapping("update")
    public String sendUpdate() {
//        System.out.println("In Profile Controller");
        return "profile/update";
    }

    @GetMapping("index")
    public String displayUserProfile(HttpSession session, Model model) {

        Integer userId = (Integer) session.getAttribute("user");
        Optional<User> result = userRepository.findById(userId);
        User user = result.get();

//        Integer profileId = (Integer) profile.getAttribute("profile");
//        Optional<Profile> result2 = profileRepository.findById(profileId);
//        Profile profile = result2.get();


//        model.addAttribute("profile", "Profile");
//        model.addAttribute("event","List Event");
//        model.addAttribute("profiles", profileRepository.findAll());
        model.addAttribute("users_name", user.getUsername());
//        model.addAttribute("profile_Id", profileRepository.getProfileId());
//        model.addAttribute("profile_Location", profileRepository.getProfileLocation());
//        model.addAttribute( "profile_Biography", profileRepository.getProfileBiography());
        return "profile/index";
    }
}

//
//    @Autowired
//    private ProfileRepository profileRepository;
//
//    @GetMapping("index")
//    public String displayEventList(Model model) {
////    public String displayEventList(HttpSession session, Model model) {
//
////        Integer userId = (Integer) session.getAttribute("user");
////        Optional<User> result = userRepository.findById(userId);
////        User user = result.get();
//
//        model.addAttribute("profile", "Profile");
////        model.addAttribute("event","List Event");
////        model.addAttribute("events", eventRepository.findAll());
////        model.addAttribute("attendedEvents", user.getEvents());
//
//        return "profile/index";
//    }
//
//
//}
