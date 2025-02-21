package com.example.resultats.repository;

import com.example.resultats.entity.Resultat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultatRepository extends JpaRepository<Resultat, Long> {
    List<Resultat>findByCoursId(Long coursId);
    List<Resultat> findByEtudiantId(Long etudiantId);
}
