package com.example.tournoifootball.services;

import com.example.tournoifootball.entities.Calendrier;
import com.example.tournoifootball.repositories.CalendrierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendrierService {

    @Autowired
    private CalendrierRepository calendrierRepository;

    public List<Calendrier> getAllCalendriers() {
        return calendrierRepository.findAll();
    }

    public Calendrier getCalendrierById(Long id) {
        return calendrierRepository.findById(id).orElse(null);
    }

    public Calendrier createCalendrier(Calendrier calendrier) {
        return calendrierRepository.save(calendrier);
    }

    public Calendrier updateCalendrier(Long id, Calendrier calendrier) {
        if (calendrierRepository.existsById(id)) {
            calendrier.setId(id);
            return calendrierRepository.save(calendrier);
        }
        return null;
    }

    public void deleteCalendrier(Long id) {
        calendrierRepository.deleteById(id);
    }
}
