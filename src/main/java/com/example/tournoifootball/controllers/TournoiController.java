package com.example.tournoifootball.controllers;

import com.example.tournoifootball.entities.Tournoi;
import com.example.tournoifootball.services.TournoiService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@AllArgsConstructor
public class TournoiController {

    private final TournoiService tournoiService;

    @GetMapping("/createTournoi")
    public String createTournoiForm(Model model) {
        model.addAttribute("tournoi", new Tournoi());
        return "createtournoi"; // Assuming you have a Thymeleaf template named "CreateTournoi.html"
    }

    @PostMapping("/saveTournoi")
    public String saveTournoi(@ModelAttribute Tournoi tournoi) {
        tournoiService.saveTournoi(tournoi);
        return "redirect:/tournoiList"; // Redirect to the tournoiList endpoint
    }


    @PostMapping("/addTournoi")
    public String addTournoi(@ModelAttribute Tournoi tournoi) {
        tournoiService.addTournoi(tournoi);
        return "redirect:/tournoiList";
    }

    @GetMapping("/tournoiList")
    public String tournoiList(ModelMap modelMap,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              @RequestParam(name = "size", defaultValue = "3") int size) {
        Page<Tournoi> tournois = tournoiService.getAllTournoisByPage(page, size);
        modelMap.addAttribute("tournoisVue", tournois);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("pages", new int[tournois.getTotalPages()]);
        return "tournoilist";
    }



    @GetMapping("/editTournoi/{id}")
    public String editTournoi(@PathVariable Long id, Model model) {
        Tournoi tournoi = tournoiService.getTournoiById(id);
        model.addAttribute("tournoi", tournoi);
        return "edittournoi";
    }

    @PostMapping("/updateTournoi")
    public String updateTournoi(@ModelAttribute Tournoi tournoi) {
        tournoiService.updateTournoiById(tournoi.getId(), tournoi);
        return "redirect:/tournoiList";
    }

    @PostMapping("/deleteTournoi/{id}")
    public String deleteTournoi(@PathVariable Long id) {
        tournoiService.deleteTournoi(id);
        return "redirect:/tournoiList";
    }
}
