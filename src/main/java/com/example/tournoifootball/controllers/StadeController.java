package com.example.tournoifootball.controllers;

import com.example.tournoifootball.entities.Stade;
import com.example.tournoifootball.repositories.StadeRepository;
import com.example.tournoifootball.services.StadeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
public class StadeController {
    private final StadeRepository stadeRepository;
    private final StadeService stadeService;

    @GetMapping("/createstade")
    public String createStade(Model model) {
        model.addAttribute("stade", new Stade());
        return "createstade";
    }

    @PostMapping("/saveStade")
    public String saveStade(@ModelAttribute Stade stade) {
        stadeService.saveStade(stade);
        return "redirect:/stadeList";
    }

    @PostMapping("/addStade")
    public String addStade(@ModelAttribute Stade stade) {
        stadeRepository.save(stade);
        return "redirect:/stadeList";
    }

    @GetMapping("/editStade/{id}")
    public String editStade(@PathVariable Long id, Model model) {
        Stade stade = stadeService.getStadeById(id);
        model.addAttribute("stade", stade);
        return "editstade";
    }

    @PostMapping("/updateStade")
    public String updateStade(@ModelAttribute Stade stade) {
        stadeService.updateStade(stade);
        return "redirect:/stadeList";
    }

    @GetMapping("/stadeList")
    public String stadeList(Model model) {
        List<Stade> stades = stadeService.getAllStades();
        model.addAttribute("stadesVue", stades);
        return "stadelist";
    }

    @PostMapping("/deleteStade/{id}")
    public String deleteStade(@PathVariable Long id) {
        stadeService.deleteStade(id);
        return "redirect:/stadeList";
    }
}
