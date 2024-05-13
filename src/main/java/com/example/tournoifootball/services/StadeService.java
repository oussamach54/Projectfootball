package com.example.tournoifootball.services;

import com.example.tournoifootball.entities.Stade;

import java.util.List;

public interface StadeService {
    List<Stade> getAllStades();

    Stade getStadeById(Long id);

    void saveStade(Stade stade);

    void updateStade(Stade stade);

    void deleteStade(Long id);
}
