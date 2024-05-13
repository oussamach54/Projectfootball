package com.example.tournoifootball.controllers;

import com.example.tournoifootball.entities.Matche;
import com.example.tournoifootball.services.MatcheService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MatcheController {

    private final MatcheService matcheService;

    public MatcheController(MatcheService matcheService) {
        this.matcheService = matcheService;
    }

    @GetMapping("/creatematche")
    public String createMatche(Model model) {
        model.addAttribute("matche", new Matche());
        return "creatematche";
    }

    @GetMapping("/matcheList")
    public String matcheList(Model model) {
        List<Matche> matches = matcheService.getAllMatches();
        model.addAttribute("matchesVue", matches);
        return "matchelist";
    }

    @PostMapping("/savematche")
    public String saveMatche(@ModelAttribute Matche matche) {
        matcheService.saveMatche(matche);
        return "redirect:/matcheList";
    }

    @GetMapping("/editMatche/{id}")
    public String editMatcheForm(@PathVariable Long id, Model model) {
        Matche matche = matcheService.getMatcheById(id);
        model.addAttribute("matche", matche);
        return "editmatche";
    }


    @PostMapping("/updatematche")
    public String updateMatche(@ModelAttribute Matche matche) {
        matcheService.updateMatche(matche);
        return "redirect:/matcheList";
    }


    @PostMapping("/deleteMatche/{id}")
    public String deleteMatche(@PathVariable Long id) {
        matcheService.deleteMatche(id);
        return "redirect:/matcheList"; // corrected redirect URL
    }

}
