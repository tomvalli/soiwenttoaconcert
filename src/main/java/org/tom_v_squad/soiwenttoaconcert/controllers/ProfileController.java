package org.tom_v_squad.soiwenttoaconcert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tom_v_squad.soiwenttoaconcert.data.UserRepository;
import org.tom_v_squad.soiwenttoaconcert.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("profile")
public class ProfileController {
    protected String user = "Sam";
    protected String location = "Boston";
    protected String biography = "A biography, or simply bio, is a detailed description of a person's life. It involves more than just the basic facts like education, work, relationships, and death; it portrays a person's experience of these life events";

    @GetMapping
    public String displayMyProfile(Model model) {
        this.user = user;
        this.location = location;
        this.biography = biography;
//        String username = user.getUsername();
//        model.addAttribute("greeting", username);
        model.addAttribute("user", "user");
        model.addAttribute("location", "location");
        model.addAttribute("biography", "biography");
        return "index";
    }
}


//    @Autowired
//    private UserRepository userRepository;
//
//    private static final String userSessionKey = "user";
//    private User updateProfile;
//
//    public User getUserFromSession(HttpSession session) {
//        Integer userId = (Integer) session.getAttribute(userSessionKey);
//        if (userId == null) {
//            return null;
//        }
//        Optional<User> user = userRepository.findById(userId);
//        if (user.isEmpty()) {
//            return null;
//        }
//        return user.get();
//    }
//
//    public void setUserRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @GetMapping("")
//    public String displayMyProfile(HttpServletRequest request, Model model) {
//        User user = getUserFromSession(request.getSession());
//        String username = user.getUsername();
////        String location = profile.getlocation();
////        String userBio = profile.getBiography();
//        model.addAttribute("greeting", username);
//        return "profile/index";
//    }
//    //
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
//
//
//
////        @PostMapping("edit")
////        public String displayUpdateMyProfile(@ModelAttribute ProfileController updateProfile,
////                                                Errors errors, Model model) {
////            if (errors.hasErrors()) {
////                model.addAttribute("title", "Create profile");
////            return "profile/edit";
////        }
////            userRepository.save(updateProfile);
////            return "profile/edit";
////    }
////
////
//    @GetMapping("edit")
//    public String createProfileForm(Model model) {
//        model.addAttribute("title", "Create Profile");
//        model.addAttribute(new User());
//        return "profile/create";
//    }
//
//    @PostMapping("create")
//    public String processCreateprofileForm(@ModelAttribute Profile newProfile,
//                                         Errors errors, Model model) {
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Create Profile");
//            return "profile/create";
//        }
//
//        User newUser = null;
//        userRepository.save(newUser);
//        return "profile/create";
//    }
//
//
//
//}
