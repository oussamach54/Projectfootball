package com.example.tournoifootball.services;

import org.springframework.stereotype.Service;
import com.example.tournoifootball.entities.Arbitre;
import com.example.tournoifootball.repositories.ArbitreRepository;

import java.util.List;

@Service
public class ArbitreService {

    private final ArbitreRepository arbitreRepository;

    public ArbitreService(ArbitreRepository arbitreRepository) {
        this.arbitreRepository = arbitreRepository;
    }

    public List<Arbitre> getAllArbitres() {
        return arbitreRepository.findAll();
    }

    public Arbitre getArbitreById(Long id) {
        return arbitreRepository.findById(id).orElse(null);
    }

    public void saveArbitre(Arbitre arbitre) {
        arbitreRepository.save(arbitre);
    }

    public void updateArbitre(Arbitre arbitre) {
        arbitreRepository.save(arbitre);
    }

    public void deleteArbitre(Long id) {
        arbitreRepository.deleteById(id);
    }
}
