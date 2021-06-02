package org.tom_v_squad.soiwenttoaconcert.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("profile")
public class ProfileController {

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
    public String goIndex() {
//        System.out.println("In Profile Controller");
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
