package com.example.tournoifootball.services;

import com.example.tournoifootball.entities.Stade;
import com.example.tournoifootball.repositories.StadeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StadeServiceImpl implements StadeService {

    private final StadeRepository stadeRepository;

    @Override
    public List<Stade> getAllStades() {
        return stadeRepository.findAll();
    }

    @Override
    public Stade getStadeById(Long id) {
        Optional<Stade> stadeOptional = stadeRepository.findById(id);
        return stadeOptional.orElse(null);
    }

    @Override
    public void saveStade(Stade stade) {
        stadeRepository.save(stade);
    }

    @Override
    public void updateStade(Stade stade) {
        stadeRepository.save(stade);
    }

    @Override
    public void deleteStade(Long id) {
        stadeRepository.deleteById(id);
    }
}
