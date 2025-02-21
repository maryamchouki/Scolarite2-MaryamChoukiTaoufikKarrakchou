package com.example.inscription.repository;

import com.example.inscription.entity.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscriptionRepository  extends JpaRepository<Inscription, Long> {
    // Rechercher les inscriptions d'un étudiant
    List<Inscription>findByEtudiantId(Long etudiantId);
    // Rechercher les inscriptions d'un cours
    List<Inscription>findByCoursId(Long coursId);

}
