package com.example.coursservice.controller;

import com.example.coursservice.entity.Cours;
import com.example.coursservice.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

    @RestController
    @RequestMapping("/api/cours")
    public class CoursController {
        @Autowired
        private CoursService coursService;
        //Ajouter un cours
        @PostMapping("/ajoute")
        public ResponseEntity<Cours> ajouterCours(@RequestBody Cours cours) {
            return ResponseEntity.ok().body(coursService.ajouterCours(cours));
        }
        //Recuperer tous les cours
        @GetMapping("/cours")
        public ResponseEntity<List<Cours>> getAllCours() {
            return ResponseEntity.ok(coursService.getAllCours());
        }
        //Recuperer un cours par ID
        @GetMapping("/{id}")
        public ResponseEntity<Cours> getCoursById(@PathVariable Long id) {
            Optional<Cours> cours =coursService.getCoursById(id);
            return cours.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        //Supprimer un cours
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void>supprimerCours(@PathVariable Long id){
            coursService.supprimerCours(id);
            return ResponseEntity.noContent().build();
        }
    }

