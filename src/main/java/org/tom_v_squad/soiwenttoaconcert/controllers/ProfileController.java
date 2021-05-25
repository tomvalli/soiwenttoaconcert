package org.tom_v_squad.soiwenttoaconcert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.tom_v_squad.soiwenttoaconcert.data.UserRepository;
import org.tom_v_squad.soiwenttoaconcert.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("profile")
public class ProfileController {

    // GETTING THE USER AUTHENTICATED NAME FOR THE PROFILE
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


    @GetMapping("update")
    @ResponseStatus //(value=HttpStatus.OK)
    @ResponseBody
    public String updateProfile(HttpServletRequest request) {
        User user = getUserFromSession(request.getSession());
        String username = user.getUsername();
//        String newUsername = user.setUsername(String username);
        String biography = user.getUserBiography();
        String location = user.getUserLocation();

        return "<html>" +
                "<body>" +
                "<h2>PROFILE</h2>" +

                "<form action='update' method='post'>" +
                "<p>Name:</p>" + username +
                "<input type='text' name='username' />" +
                "<p>Bio:</p>"+ biography +
                "<input type='text' name='biography' />" +
                "<p>Location:</p>"+ location +
                "<input type='text' name='location' />" +
                "<input type='submit' value='update'/>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @PostMapping("update")
    @ResponseBody
    public String updateProfile(@RequestParam String username) {

        return "<html><body><h2>" + username + " was added!</h2></body></html>";
    }
//    return redirect:../
}
