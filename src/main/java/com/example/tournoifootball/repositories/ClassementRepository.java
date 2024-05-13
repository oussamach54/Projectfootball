package com.example.tournoifootball.repositories;

import com.example.tournoifootball.entities.Classement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassementRepository extends JpaRepository<Classement, Long> {
}
