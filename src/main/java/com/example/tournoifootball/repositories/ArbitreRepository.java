package com.example.tournoifootball.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tournoifootball.entities.Arbitre;

@Repository
public interface ArbitreRepository extends JpaRepository<Arbitre, Long> {

}
