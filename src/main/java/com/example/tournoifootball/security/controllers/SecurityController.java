package com.example.tournoifootball.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    @GetMapping("/")
    public String home(){
        return "redirect:/tournoiList";
    }

    @GetMapping("/accessdenied")
    public String accessDenied(){
        return "redirect:/accessdenied";
    }
}
