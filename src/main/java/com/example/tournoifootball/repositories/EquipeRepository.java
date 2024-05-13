package com.example.tournoifootball.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tournoifootball.entities.Equipe;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {

    List<Equipe> findByPaysIgnoreCase(String nom);
    Equipe findByNom(String nom);
}
