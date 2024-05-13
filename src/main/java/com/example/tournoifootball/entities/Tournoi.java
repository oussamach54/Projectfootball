package com.example.tournoifootball.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tournoi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nom;
    String lieu;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date date;

    @OneToMany(mappedBy = "tournoi")
    List<Calendrier> calendriers;

    public void setDate(Date date) {
        this.date = date;
    }
}
