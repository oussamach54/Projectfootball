package com.example.tournoifootball.repositories;

import com.example.tournoifootball.entities.Tournoi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TournoiRepository extends JpaRepository<Tournoi, Long> {


}
