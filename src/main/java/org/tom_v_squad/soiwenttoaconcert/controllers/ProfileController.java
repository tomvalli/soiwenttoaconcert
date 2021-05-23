package org.tom_v_squad.soiwenttoaconcert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.tom_v_squad.soiwenttoaconcert.data.UserRepository;
import org.tom_v_squad.soiwenttoaconcert.models.User;

import javax.persistence.MappedSuperclass;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;



@Controller
@RequestMapping("profile")
public class ProfileController {
//    protected String biography = "A biography, or simply bio, is a detailed description of a person's life. It involves more than just the basic facts like education, work, relationships, and death; it portrays a person's experience of these life events";
//    protected String location = "New York City";

    @Autowired
    private UserRepository userRepository;


    // GETTING THE USER AUTHENTICATED NAME FOR THE PROFILE
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


    // SHOWING THE PROFILE TO THE FRONT END

    @GetMapping("")
    public String displayMyProfile(HttpServletRequest request, Model model) {
//        this.biography = biography;
//        this.location = location;
        User user = getUserFromSession(request.getSession());
        String username = user.getUsername();
//        String bio = user.getUserBiography();
//        String location = user.getUserLocation();
        model.addAttribute("greeting", username);
        model.addAttribute("biography", user.getUserBiography());
        model.addAttribute("location", user.getUserLocation());
        return "profile/index";
//        return "profile/index";
    }

    @GetMapping("update")
    public String displayViewArtist(Model model, @PathVariable int userId) {
        Optional<User> result = userRepository.findById(userId);
        if (result.isPresent()) {
            User profile = result.get();
            model.addAttribute("profile", profile);
            return "";
        } else {
            return "redirect:../";
        }


        @PostMapping("update")
        public String processCreateProfile(@ModelAttribute User updateUser,
                Errors errors, Model model){
            if (errors.hasErrors()) {
                model.addAttribute("title", "Update Profile");
                return "profile/update";
            }

            User updateUser = null;
            userRepository.save(updateUser);
            return "redirect: ";
        }
    }
}
        //
//    @GetMapping("edit")
//    public String displayUpdateMyProfile(@ModelAttribute User updateProfile,
//                                         Errors errors, Model model) {
//            if (errors.hasErrors()) {
//                model.addAttribute("title", "Create profile");
//            return "profile/edit";
//        }
//            userRepository.save(updateProfile);
//        return "profile/edit";
//    }


//        @PostMapping("edit")
//        public String displayUpdateMyProfile(@ModelAttribute ProfileController updateProfile,
//                                                Errors errors, Model model) {
//            if (errors.hasErrors()) {
//                model.addAttribute("title", "Create profile");
//            return "profile/edit";
//        }
//            userRepository.save(updateProfile);
//            return "profile/edit";
//    }


//    @GetMapping("edit")
//    public String createProfileForm(Model model) {
//        model.addAttribute("title", "Create Profile");
//        model.addAttribute(new User());
//        return "profile/create";
//    }




