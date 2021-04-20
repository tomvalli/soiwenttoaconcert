//package org.tom_v_squad.soiwenttoaconcert.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class HomeController {
//    @GetMapping("index") {
//        public String indexMethod () {
//            return "index";
//
//        }
//
//
//    }
package org.tom_v_squad.soiwenttoaconcert.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping
    public String index(){
        return "index";
    }
}
