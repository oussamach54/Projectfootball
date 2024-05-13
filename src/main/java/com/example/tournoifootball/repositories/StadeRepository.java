package com.example.tournoifootball.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tournoifootball.entities.Stade;

@Repository
public interface StadeRepository extends JpaRepository<Stade, Long> {

}
