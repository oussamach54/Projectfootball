package com.example.tournoifootball.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import com.example.tournoifootball.entities.Equipe;
import com.example.tournoifootball.entities.Joueur;
import com.example.tournoifootball.entities.Matche;
import com.example.tournoifootball.repositories.EquipeRepository;
import com.example.tournoifootball.repositories.JoueurRepository;
import com.example.tournoifootball.repositories.MatcheRepository;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@AllArgsConstructor
@Service
public class EquipeService {
    private final EquipeRepository equipeRepository;

    EquipeRepository er;

    JoueurRepository jr;

    MatcheRepository mr;





    public Equipe addEquipe(  Equipe e) {
        return er.save(e);
    }

    public List<Equipe> getAllEquipes(){
        return er.findAll();
    }



    public Page<Equipe> getAllEquipesByPage(int page, int size) {
        return equipeRepository.findAll(PageRequest.of(page, size));
    }


    public Equipe getEquipeById(Long id) {
        Optional<Equipe> equipeOptional = er.findById(id);
        if (equipeOptional.isPresent()) {
            return equipeOptional.get();
        } else {
            // Handle the case when the Equipe is not found
            throw new EntityNotFoundException("Equipe not found with id: " + id);
        }
    }


    //we'll add player to equipe with id in url
    public Joueur addJoueurToEquipe(Long id, Joueur m) {
        Equipe e = er.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Equipe not found with id: " + id));
        m.setEquipe(e);
        return jr.save(m);
    }

    public List<Equipe> findByPays(String maroc) {

        return er.findByPaysIgnoreCase("Maroc");
    }

    //show list of players that belongs to an equipe with id url
    public List<Joueur> getJoueurByEquipeId(Long id) {
        Equipe e = er.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Equipe not found with id: " + id));
        return jr.findByEquipe(e);
    }

    //show list of players that belongs to an equipe with nom in url
    public List<Joueur> getJoueurByEquipeNom(  String nom) {
        Equipe e = er.findByNom(nom);
        return jr.findByEquipe(e);
    }

    public List<Joueur> getJoueurByEquipeNomAndPost(  String nom,  String post) {
        Equipe e = er.findByNom(nom);
        //System.out.println(e.getNom());

        List<Joueur> joueurs= jr.findByEquipe(e);
        System.out.println(joueurs.isEmpty());
        List<Joueur> attaquants = new ArrayList<>();
        joueurs.forEach(m->{//expression lambda
            if(m.getAge().equals(post)) attaquants.add(m);
        });

        return attaquants;

    }

    //we'll add a match to an equipe, as an equipe1, match will save all infos of that equipe as an equipe1
    public Matche addMatcheToEquipe1(  Long id,   Matche m,   Long id2) {
        //we see if that equipe with first id in url exists we fetch the whole equipe
        Equipe e= er.findById(id).orElseThrow(() -> new EntityNotFoundException("Equipe not found"));
        //we check if that match already exists, we extract the whole match
        Matche m2= mr.findById(id2).orElse(null);
        //System.out.println(m2);
        //if the match doesn't exist, we take the Matche from body, add equipe 1 and save to bd
        if(m2==null) {m.setEquipe1(e); return mr.save(m);}
        //or else we take the already ex match, add equipe1 to it and update it
        else {m2.setEquipe1(e);
            return mr.save(m2);}
    }

    public Matche addMatcheToEquipe2(  Long id,   Matche m,   Long id2) {
        Equipe e= er.findById(id).orElseThrow(() -> new EntityNotFoundException("Equipe not found"));
        Matche m2= mr.findById(id2).orElse(null);
        //System.out.println(m2);
        if(m2==null) {m.setEquipe2(e); return mr.save(m);}
        else m2.setEquipe2(e);
        return mr.save(m2);
    }

    public List<Matche> getMatchByEquipe1Id(Long id) {
        Equipe e = er.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Equipe not found with id: " + id));
        return mr.findByEquipe1(e);
    }


    public List<Matche> getMatchByEquipe2Id(Long id) {
        Equipe e = er.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Equipe not found with id: " + id));
        return mr.findByEquipe2(e);
    }



    public void deleteEquipe(  Long id) {

        List<Joueur> joueurs=getJoueurByEquipeId(id);
        List<Matche> matches1=getMatchByEquipe1Id(id);
        List<Matche> matches2=getMatchByEquipe2Id(id);

        joueurs.forEach(m->{//expression lambda
            m.setEquipe(null);
        });
        matches1.forEach(m-> m.setEquipe1(null));
        matches2.forEach(m-> m.setEquipe2(null));

        er.deleteById(id);
    }



    public Equipe editEquipe(Long id, Equipe equipe) {
        Equipe existingEquipe = er.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Equipe not found with id: " + id));

        existingEquipe.setNom(equipe.getNom());
        existingEquipe.setPays(equipe.getPays());

        return er.save(existingEquipe);
    }


    public void updateEquipe(Equipe equipe) {
        Long id = equipe.getId();
        Equipe existingEquipe = er.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Equipe not found with id: " + id));

        existingEquipe.setNom(equipe.getNom());
        existingEquipe.setPays(equipe.getPays());

        er.save(existingEquipe);
    }

}

