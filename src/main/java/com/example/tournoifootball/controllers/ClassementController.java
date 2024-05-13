package com.example.tournoifootball.controllers;

import com.example.tournoifootball.entities.Classement;
import com.example.tournoifootball.services.ClassementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classements")
public class ClassementController {

    @Autowired
    private ClassementService classementService;

    @GetMapping
    public List<Classement> getAllClassements() {
        return classementService.getAllClassements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classement> getClassementById(@PathVariable Long id) {
        Classement classement = classementService.getClassementById(id);
        if (classement != null) {
            return ResponseEntity.ok(classement);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Classement> createClassement(@RequestBody Classement classement) {
        Classement createdClassement = classementService.createClassement(classement);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClassement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Classement> updateClassement(@PathVariable Long id, @RequestBody Classement classement) {
        Classement updatedClassement = classementService.updateClassement(id, classement);
        if (updatedClassement != null) {
            return ResponseEntity.ok(updatedClassement);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClassement(@PathVariable Long id) {
        classementService.deleteClassement(id);
        return ResponseEntity.noContent().build();
    }
}
