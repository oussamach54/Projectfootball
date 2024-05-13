package com.example.tournoifootball.controllers;

import com.example.tournoifootball.entities.Arbitre;
import com.example.tournoifootball.services.ArbitreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ArbitreController {

    private final ArbitreService arbitreService;

    public ArbitreController(ArbitreService arbitreService) {
        this.arbitreService = arbitreService;
    }

    @GetMapping("/createarbitre")
    public String createArbitre(Model model) {
        model.addAttribute("arbitre", new Arbitre());
        return "createarbitre";
    }

    @GetMapping("/arbitreList")
    public String arbitreList(Model model) {
        List<Arbitre> arbitres = arbitreService.getAllArbitres();
        model.addAttribute("arbitresVue", arbitres);
        return "arbitrelist";
    }

    @PostMapping("/saveArbitre")
    public String saveArbitre(@ModelAttribute Arbitre arbitre) {
        arbitreService.saveArbitre(arbitre);
        return "redirect:/arbitreList";
    }


    @GetMapping("/editArbitre/{id}")
    public String editArbitreForm(@PathVariable Long id, Model model) {
        Arbitre arbitre = arbitreService.getArbitreById(id);
        model.addAttribute("arbitre", arbitre);
        return "editarbitre";
    }

    @PostMapping("/updateArbitre")
    public String updateArbitre(@ModelAttribute Arbitre arbitre) {
        arbitreService.updateArbitre(arbitre);
        return "redirect:/arbitreList";
    }

    @PostMapping("/deleteArbitre/{id}")
    public String deleteArbitre(@PathVariable Long id) {
        arbitreService.deleteArbitre(id);
        return "redirect:/arbitreList";
    }

}
