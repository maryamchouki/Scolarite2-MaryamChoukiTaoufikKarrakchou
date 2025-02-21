package com.example.etudiantservice.controller;

import com.example.etudiantservice.entity.Etudiant;
import com.example.etudiantservice.repository.EtudiantRepository;
import com.example.etudiantservice.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class EtudiantController {
    private final EtudiantService etudiantService;

    // Constructeur pour injecter EtudiantService
    @Autowired
    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    // Récupérer tous les étudiants
    @GetMapping("/etudiants")
    public List<Etudiant> allEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    // Récupérer un étudiant par ID
    @GetMapping("/etudiants/{id}")
    public Etudiant getEtudiantById(@PathVariable Long id) {
        return etudiantService.getEtudiantById(id);
    }

    //ajouter un étudiant
    @PostMapping("/etudiants")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.saveEtudiant(etudiant);
    }

    @DeleteMapping("/etudiants/{id}")
    public void deleteEtudiantById(@PathVariable Long id) {
        etudiantService.supprimerEtudiant(id);
    }
}
