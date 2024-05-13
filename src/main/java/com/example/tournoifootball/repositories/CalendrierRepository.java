package com.example.tournoifootball.repositories;

import com.example.tournoifootball.entities.Calendrier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendrierRepository extends JpaRepository<Calendrier, Long> {
}
