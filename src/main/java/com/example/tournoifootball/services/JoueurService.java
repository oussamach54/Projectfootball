package com.example.tournoifootball.services;

import org.springframework.stereotype.Service;
import com.example.tournoifootball.entities.Joueur;
import com.example.tournoifootball.repositories.JoueurRepository;

import java.util.List;

@Service
public class JoueurService {

    private final JoueurRepository joueurRepository;

    public JoueurService(JoueurRepository joueurRepository) {
        this.joueurRepository = joueurRepository;
    }

    public List<Joueur> getAllJoueurs() {
        return joueurRepository.findAll();
    }

    public Joueur getJoueurById(Long id) {
        return joueurRepository.findById(id).orElse(null);
    }

    public void addJoueur(Joueur joueur) {
        joueurRepository.save(joueur);
    }
    public void saveJoueur(Joueur joueur) {
        joueurRepository.save(joueur);
    }

    public void updateJoueur(Joueur joueur) {
        joueurRepository.save(joueur);
    }

    public void deleteJoueur(Long id) {
        joueurRepository.deleteById(id);
    }

}
