package com.example.tournoifootball.entities;

import java.time.LocalDate;

import jakarta.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Matche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDate dateMatch;
    String lieu;
    @ManyToOne
    @JoinColumn(name = "equipe1")
    Equipe equipe1;
    @ManyToOne
    @JoinColumn(name = "equipe2")
    Equipe equipe2;
    @ManyToOne
    @JoinColumn(name = "arbitre_id")
    Arbitre arbitre;
    @ManyToOne
    @JoinColumn(name = "stade_id")
    Stade stade;
    @ManyToOne
    @JoinColumn(name = "tournoi_id")
    Tournoi tournoi;
}


