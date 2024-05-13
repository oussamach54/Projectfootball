package com.example.tournoifootball.repositories;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tournoifootball.entities.Arbitre;
import com.example.tournoifootball.entities.Equipe;
import com.example.tournoifootball.entities.Matche;
import com.example.tournoifootball.entities.Stade;

@Repository
public interface MatcheRepository extends JpaRepository<Matche, Long> {
    List<Matche> findByArbitre(Arbitre a);
    List<Matche> findByStade(Stade a);
    List<Matche> findByEquipe1(Equipe a);
    List<Matche> findByEquipe2(Equipe a);

    void deleteByDateMatchLessThanEqual(LocalDate date);
}

