package com.example.etudiantservice.repository;

import com.example.etudiantservice.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {

}

