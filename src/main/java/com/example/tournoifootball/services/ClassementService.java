package com.example.tournoifootball.services;

import com.example.tournoifootball.entities.Classement;
import com.example.tournoifootball.repositories.ClassementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassementService {

    @Autowired
    private ClassementRepository classementRepository;

    public List<Classement> getAllClassements() {
        return classementRepository.findAll();
    }

    public Classement getClassementById(Long id) {
        return classementRepository.findById(id).orElse(null);
    }

    public Classement createClassement(Classement classement) {
        return classementRepository.save(classement);
    }

    public Classement updateClassement(Long id, Classement classement) {
        if (classementRepository.existsById(id)) {
            classement.setId(id);
            return classementRepository.save(classement);
        }
        return null;
    }

    public void deleteClassement(Long id) {
        classementRepository.deleteById(id);
    }
}
