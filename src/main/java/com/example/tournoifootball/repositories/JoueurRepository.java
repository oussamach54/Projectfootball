package com.example.tournoifootball.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tournoifootball.entities.Equipe;
import com.example.tournoifootball.entities.Joueur;


@Repository
public interface JoueurRepository extends JpaRepository<com.example.tournoifootball.entities.Joueur, Long> {

    List<Joueur> findByEquipe(Equipe a);

}
