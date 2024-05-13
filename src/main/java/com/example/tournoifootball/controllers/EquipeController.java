package com.example.tournoifootball.controllers;

import com.example.tournoifootball.entities.Equipe;
import com.example.tournoifootball.entities.Joueur;
import com.example.tournoifootball.entities.Matche;
import com.example.tournoifootball.repositories.EquipeRepository;
import com.example.tournoifootball.services.EquipeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
public class EquipeController {

    private EquipeService equipeService;

    private EquipeRepository equipeRepository;



    @GetMapping("/createequipe")
    public String showCreateEquipePage() {
        return "createequipe";
    }

    @PostMapping("/saveEquipe")
    public String saveEquipe(@ModelAttribute Equipe equipe) {
        equipeService.addEquipe(equipe);
        return "redirect:/equipeList";
    }

    @PostMapping("/equipe")
    public String addEquipe(@ModelAttribute Equipe equipe) {
        equipeService.addEquipe(equipe);
        return "redirect:/equipeList";
    }

    @GetMapping("/equipeList")
    public String equipeList(ModelMap modelMap,
                             @RequestParam(name="page",defaultValue = "0") int page,
                             @RequestParam(name = "size",defaultValue = "3") int size
                             ) {
        Page<Equipe> equipes = equipeService.getAllEquipesByPage(page,size);
        modelMap.addAttribute("equipesVue", equipes);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("pages", new int[equipes.getTotalPages()]);
        return "equipelist";
    }

    @GetMapping("/equipe")
    public List<Equipe> getAllEquipes() {
        return equipeService.getAllEquipes();
    }

    @GetMapping("/equipe/{id}")
    public Equipe getEquipeById(@PathVariable Long id) {
        return equipeService.getEquipeById(id);
    }

    @PostMapping("/equipe/{id}/joueur")
    public Joueur addJoueurToEquipe(@PathVariable Long id, @RequestBody Joueur joueur) {
        return equipeService.addJoueurToEquipe(id, joueur);
    }

    @GetMapping("/equipe/maroc")
    public List<Equipe> findByPays() {
        return equipeService.findByPays("Maroc");
    }

    @GetMapping("/equipe/{id}/joueur")
    public List<Joueur> getJoueurByEquipeId(@PathVariable Long id) {
        return equipeService.getJoueurByEquipeId(id);
    }

    @GetMapping("/equipe/nom/{nom}/joueur")
    public List<Joueur> getJoueurByEquipeNom(@PathVariable String nom) {
        return equipeService.getJoueurByEquipeNom(nom);
    }

    @GetMapping("/equipe/nom/{nom}/post/{post}")
    public List<Joueur> getJoueurByEquipeNomAndPost(@PathVariable String nom, @PathVariable String post) {
        return equipeService.getJoueurByEquipeNomAndPost(nom, post);
    }

    @PostMapping("/equipe1/{id}/matche/{id2}")
    public Matche addMatcheToEquipe1(@PathVariable Long id, @RequestBody Matche matche, @PathVariable Long id2) {
        return equipeService.addMatcheToEquipe1(id, matche, id2);
    }

    @PostMapping("/equipe2/{id}/matche/{id2}")
    public Matche addMatcheToEquipe2(@PathVariable Long id, @RequestBody Matche matche, @PathVariable Long id2) {
        return equipeService.addMatcheToEquipe2(id, matche, id2);
    }

    @GetMapping("/equipe1/{id}/match")
    public List<Matche> getMatchByEquipe1Id(@PathVariable Long id) {
        return equipeService.getMatchByEquipe1Id(id);
    }

    @GetMapping("/equipe2/{id}/match")
    public List<Matche> getMatchByEquipe2Id(@PathVariable Long id) {
        return equipeService.getMatchByEquipe2Id(id);
    }


    @RequestMapping("/deleteEquipe")
    public String deleteEquipe(@RequestParam("id") Long id, ModelMap modelMap,
                               @RequestParam(name="page",defaultValue = "0") int page,
                               @RequestParam(name = "size",defaultValue = "3") int size
    ) {
        equipeService.deleteEquipe(id);
        List<Equipe> equipesList = equipeService.getAllEquipes();
        modelMap.addAttribute("equipesVue", equipesList);
        Page<Equipe> equipesPage = equipeService.getAllEquipesByPage(page,size);
        modelMap.addAttribute("equipesVue", equipesPage);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("pages", new int[equipesPage.getTotalPages()]);
        return "equipelist";
    }



    @RequestMapping("/editEquipe")
    public String editEquipe(@RequestParam("id") Long id, Model model) {
        Equipe equipe = equipeService.getEquipeById(id);
        model.addAttribute("equipe", equipe);
        return "EditEquipe";
    }

    @PostMapping("/updateEquipe")
    public String updateEquipe(@ModelAttribute Equipe equipe) {
        equipeService.updateEquipe(equipe);
        return "redirect:/equipeList";
    }


}
