package com.example.tournoifootball.entities;



import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Classement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String equipe;
    int points;

    @ManyToOne
    Tournoi tournoi;
}
