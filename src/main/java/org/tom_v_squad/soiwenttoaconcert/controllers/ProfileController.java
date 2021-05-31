package org.tom_v_squad.soiwenttoaconcert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.tom_v_squad.soiwenttoaconcert.data.ProfileRepository;
import org.tom_v_squad.soiwenttoaconcert.data.UserRepository;
import org.tom_v_squad.soiwenttoaconcert.models.Profile;
import org.tom_v_squad.soiwenttoaconcert.models.User;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("profile")
public class ProfileController {

    // GETTING THE USER AUTHENTICATED NAME FOR THE PROFILE

    /////////////////////// USER
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    /////////////////////// USER
    private static final String userSessionKey = "user";

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

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("profiles", profileRepository.findAll());
        return "profiles/index";
    }


    @GetMapping("add")
    public String displayAddProfileForm(Model model) {
        model.addAttribute(new Profile());
        return "profiles/add";
    }

    @PostMapping("add")
    public String processAddProfileForm(@ModelAttribute @Valid Profile newProfile, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "profiles/add";
        }

        profileRepository.save(newProfile);
        return "redirect:";
    }

    @GetMapping("view/{profileId}")
    public String displayViewProfile(Model model, @PathVariable int profileId) {
        Optional<Profile> result = profileRepository.findById(profileId);
        if (result.isPresent()) {
            Profile profile = result.get();
            model.addAttribute("profile", profile);
            return "profile/view";
        } else {
            return "redirect:../";
        }
    }

    /////////////////////// USER
//    @GetMapping("view")
//    @ResponseBody
//    public String viewProfile(@RequestParam String username) {
//        return "<html><body><h2>" + username + " was added!</h2></body></html>";
//    }

    /////////////////////// USER
//    @GetMapping("update")
////    @ResponseStatus //(value=HttpStatus.OK)
////    @ResponseBody
//    public String updateProfile(HttpServletRequest request) {
//        User user = getUserFromSession(request.getSession());
//        String username = user.getUsername();
////        String newUsername = user.setUsername(String username);
//        String biography = user.getUserBiography();
//        String location = user.getUserLocation();
//
//        return "<html>" +
//                "<body>" +
//                "<h2>PROFILE</h2>" +
//
//                "<form action='update' method='post'>" +
//                "<p>Name:</p>" + username +
//                "<input type='text' name='username' />" +
//                "<p>Bio:</p>"+ biography +
//                "<input type='text' name='biography' />" +
//                "<p>Location:</p>"+ location +
//                "<input type='text' name='location' />" +
//                "<input type='submit' value='update'/>" +
//                "</form>" +
//                "</body>" +
//                "</html>";
//    }

    /////////////////////// USER
//    @PostMapping("update")
//    @ResponseBody
//    public String updateProfile(@RequestParam String username) {
//
//        return "<html><body><h2>" + username + " was added!</h2></body></html>";
//    }
//    return redirect:../
}
