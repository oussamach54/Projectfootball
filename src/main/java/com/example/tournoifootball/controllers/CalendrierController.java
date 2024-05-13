package com.example.tournoifootball.controllers;

import com.example.tournoifootball.entities.Calendrier;
import com.example.tournoifootball.services.CalendrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendriers")
public class CalendrierController {

    @Autowired
    private CalendrierService calendrierService;

    @GetMapping
    public List<Calendrier> getAllCalendriers() {
        return calendrierService.getAllCalendriers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Calendrier> getCalendrierById(@PathVariable Long id) {
        Calendrier calendrier = calendrierService.getCalendrierById(id);
        if (calendrier != null) {
            return ResponseEntity.ok(calendrier);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Calendrier> createCalendrier(@RequestBody Calendrier calendrier) {
        Calendrier createdCalendrier = calendrierService.createCalendrier(calendrier);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCalendrier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Calendrier> updateCalendrier(@PathVariable Long id, @RequestBody Calendrier calendrier) {
        Calendrier updatedCalendrier = calendrierService.updateCalendrier(id, calendrier);
        if (updatedCalendrier != null) {
            return ResponseEntity.ok(updatedCalendrier);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCalendrier(@PathVariable Long id) {
        calendrierService.deleteCalendrier(id);
        return ResponseEntity.noContent().build();
    }
}
