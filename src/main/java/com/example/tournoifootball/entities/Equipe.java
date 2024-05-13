package com.example.tournoifootball.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(columnDefinition = "VARCHAR(255)")
    String nom;

    String pays;

    @OneToMany(mappedBy = "equipe1")
    @JsonIgnore
    List<Matche> matchesAsEquipe1;

    @OneToMany(mappedBy = "equipe2")
    @JsonIgnore
    List<Matche> matchesAsEquipe2;

    @OneToMany(mappedBy = "equipe")
    @JsonIgnore
    List<Joueur> joueurs;
}
