package com.example.inscription.controller;


import com.example.inscription.entity.Inscription;
import com.example.inscription.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inscriptions")
public class InscriptionController {
    @Autowired
    private InscriptionService inscriptionService;
    // Ajouter une inscription
    @PostMapping("/add")
    public ResponseEntity<Inscription>addInscription(@RequestParam Long etudiantId, @RequestParam Long coursId) {
     Inscription inscription =inscriptionService.inscriptionEtudiant(etudiantId, coursId);
     return ResponseEntity.ok(inscription);
    }
    // Récupérer une inscription par ID
    @GetMapping("/{id}")
    public ResponseEntity<Inscription>getInscription(@PathVariable Long id) {
        Optional<Inscription> inscription = inscriptionService.getInscription(id);
        return inscription.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    // Récupérer toutes les inscriptions
    @GetMapping("/inscription")
    public ResponseEntity<List<Inscription>> getAllInscriptions() {
        return ResponseEntity.ok(inscriptionService.getAllInscriptions());
    }
    // Supprimer une inscription
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteInscription(@PathVariable Long id) {
        inscriptionService.deleteInscription(id);
        return ResponseEntity.noContent().build();
    }
    // Récupérer les inscriptions d'un étudiant
    @GetMapping("/etudiant/{etudiantId}")
    public ResponseEntity<List<Inscription>> getInscriptionByEtudiantId(@PathVariable Long etudiantId) {
        return ResponseEntity.ok(inscriptionService.getInscriptionsByEtudiant(etudiantId));
    }
    // Récupérer les inscriptions d'un cours
    @GetMapping("/cours/{coursId}")
    public ResponseEntity<List<Inscription>> getInscriptionByCoursId(@PathVariable Long coursId) {
        return ResponseEntity.ok(inscriptionService.getInscriptionsByCours(coursId));
    }
}
