package com.example.tournoifootball.services;

import com.example.tournoifootball.entities.Matche;

import java.util.List;

public interface MatcheService {
    List<Matche> getAllMatches();

    Matche getMatcheById(Long id);

    void saveMatche(Matche matche);

    void updateMatche(Matche matche);

    void deleteMatche(Long id);
}

