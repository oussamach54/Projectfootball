package com.example.tournoifootball.services;

import com.example.tournoifootball.entities.Matche;
import com.example.tournoifootball.repositories.MatcheRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatcheServiceImpl implements MatcheService {

    private final MatcheRepository matcheRepository;

    public MatcheServiceImpl(MatcheRepository matcheRepository) {
        this.matcheRepository = matcheRepository;
    }

    @Override
    public List<Matche> getAllMatches() {
        return matcheRepository.findAll();
    }

    @Override
    public Matche getMatcheById(Long id) {
        return matcheRepository.findById(id).orElse(null);
    }

    @Override
    public void saveMatche(Matche matche) {
        matcheRepository.save(matche);
    }

    @Override
    public void updateMatche(Matche matche) {
        matcheRepository.save(matche);
    }

    @Override
    public void deleteMatche(Long id) {
        matcheRepository.deleteById(id);
    }
}
