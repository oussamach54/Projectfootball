package com.example.tournoifootball.controllers;

import com.example.tournoifootball.entities.Joueur;
import com.example.tournoifootball.repositories.JoueurRepository;
import com.example.tournoifootball.services.JoueurService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
public class JoueurController {
    private final JoueurRepository joueurRepository;
    private final JoueurService joueurService;

    @GetMapping("/createJoueur")
    public String createJoueur(Model model) {
        model.addAttribute("joueur", new Joueur());
        return "CreateJoueur";
    }

    @PostMapping("/saveJoueur")
    public String saveJoueur(@ModelAttribute Joueur joueur) {
        joueurService.saveJoueur(joueur);
        return "redirect:/joueurList";
    }

    @PostMapping("/addJoueur")  // <-- Added mapping for adding joueur
    public String addJoueur(@ModelAttribute Joueur joueur) {
        joueurRepository.save(joueur);  // <-- Save joueur using repository
        return "redirect:/joueurList";
    }




    @GetMapping("/editJoueur/{id}")
    public String editJoueur(@PathVariable Long id, Model model) {
        Joueur joueur = joueurService.getJoueurById(id);
        model.addAttribute("joueur", joueur);
        return "EditJoueur";
    }

    @PostMapping("/updateJoueur")
    public String updateJoueur(@ModelAttribute Joueur joueur) {
        joueurService.updateJoueur(joueur);
        return "redirect:/joueurList";
    }
    @GetMapping("/joueurList")
    public String joueurList(Model model) {
        List<Joueur> joueurs = joueurService.getAllJoueurs();
        model.addAttribute("joueursVue", joueurs);
        return "joueurlist";
    }

    @PostMapping("/deleteJoueur/{id}")
    public String deleteJoueur(@PathVariable Long id) {
        joueurService.deleteJoueur(id);
        return "redirect:/joueurList";
    }
}


