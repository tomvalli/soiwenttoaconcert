package org.tom_v_squad.soiwenttoaconcert.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public class ProfileController {
    @GetMapping("dog")
    @ResponseBody
    public String barkWithNoName () {
        return "<html>" +
                "<body>" +
                "<h2>My Dog Page</h2>" +
                "<form action='update' method='post'>" +
                "<input type='text' name='dogName' />" +
                "<input type='submit' value='update'/>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @PostMapping("update")
    @ResponseBody
    public String updateTheDog(@RequestParam String dogName) {
        return "<html><body><h2>" + dogName + " was added!</h2></body></html>";
    }
}
