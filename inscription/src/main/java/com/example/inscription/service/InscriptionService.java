package com.example.inscription.service;


import com.example.inscription.entity.Inscription;
import com.example.inscription.repository.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscriptionService {
    @Autowired
    private InscriptionRepository inscriptionRepository;

    // Ajouter une inscription
    public Inscription inscriptionEtudiant(Long etudiantId, Long coursId) {
        Inscription inscription = Inscription.builder()
                .etudiantId(etudiantId)
                .coursId(coursId)
                .build();
        return inscriptionRepository.save(inscription);
    }

    // Récupérer une inscription par ID
    public Optional<Inscription> getInscription(Long id) {
        return inscriptionRepository.findById(id);
    }
    // Récupérer toutes les inscriptions
    public List<Inscription> getAllInscriptions() {
        return inscriptionRepository.findAll();
    }
    // Supprimer une inscription
    public void deleteInscription(Long id) {
        inscriptionRepository.deleteById(id);
    }
    // Récupérer les inscriptions d'un étudiant
    public List<Inscription>getInscriptionsByEtudiant(Long etudiantId) {
        return inscriptionRepository.findByEtudiantId(etudiantId);
    }
    // Récupérer les inscriptions d'un cours
    public List<Inscription> getInscriptionsByCours(Long coursId) {
        return inscriptionRepository.findByCoursId(coursId);
    }
}






