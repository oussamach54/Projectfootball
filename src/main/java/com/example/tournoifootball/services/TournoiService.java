package com.example.tournoifootball.services;

import com.example.tournoifootball.entities.Tournoi;
import com.example.tournoifootball.repositories.TournoiRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


import java.util.Date;


@Service
public class TournoiService {

    private final TournoiRepository tournoiRepository;

    public TournoiService(TournoiRepository tournoiRepository) {
        this.tournoiRepository = tournoiRepository;
    }
    public void saveTournoi(Tournoi tournoi) {
        tournoi.setDate(new Date()); // Set the current date
        tournoiRepository.save(tournoi);
    }

    public Page<Tournoi> getAllTournoisByPage(int page, int size) {
        return tournoiRepository.findAll(PageRequest.of(page, size));
    }


    public void addTournoi(Tournoi tournoi) {
        tournoiRepository.save(tournoi);
    }

    public Tournoi getTournoiById(Long id) {
        return tournoiRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tournoi not found with id: " + id));
    }

    public void updateTournoiById(Long id, Tournoi updatedTournoi) {
        Tournoi existingTournoi = tournoiRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tournoi not found with id: " + id));

        if (updatedTournoi != null) {
            existingTournoi.setNom(updatedTournoi.getNom());

            existingTournoi.setLieu(updatedTournoi.getLieu());
            tournoiRepository.save(existingTournoi);
        }
    }


    public void deleteTournoi(Long id) {
        tournoiRepository.deleteById(id);
    }
}
