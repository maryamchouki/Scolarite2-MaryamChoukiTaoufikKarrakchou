package com.example.resultats.service;


import com.example.resultats.entity.Resultat;
import com.example.resultats.repository.ResultatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultatService {
    private final ResultatRepository resultatRepository;
    @Autowired
    public ResultatService(ResultatRepository resultatRepository) {

        this.resultatRepository = resultatRepository;
    }
    public List<Resultat> getResultatsByEtudiant(Long etudiantId) {
        return resultatRepository.findByEtudiantId(etudiantId);
    }

    public List<Resultat> getResultatsByCours(Long coursId) {
        return resultatRepository.findByCoursId(coursId);
    }

    public Resultat saveResultat(Resultat resultat) {
        return resultatRepository.save(resultat);
    }

    public void deleteResultat(Long id) {
        resultatRepository.deleteById(id);
    }
}
