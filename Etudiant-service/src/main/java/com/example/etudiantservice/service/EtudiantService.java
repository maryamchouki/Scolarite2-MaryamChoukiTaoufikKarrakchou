package com.example.etudiantservice.service;

import com.example.etudiantservice.entity.Etudiant;
import com.example.etudiantservice.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EtudiantService {

        private  EtudiantRepository repository;
        public EtudiantService(EtudiantRepository repository) {
            this.repository = repository;
        }
        //Ajouter un etudiant
        public Etudiant ajouterEtudiant(Etudiant etudiant) {
            return repository.save(etudiant);
        }
        //recuperer tous les etudiants
        public List<Etudiant> getAllEtudiants() {
            return repository.findAll();
        }
        //Recuperer un etudiant par son ID
        public Etudiant getEtudiantById(Long id) {

            return repository.findById(id).get();
        }
       // methode pour enregistrer un etudiant
        public Etudiant saveEtudiant(Etudiant etudiant) {
            return repository.save(etudiant);
        }
        //Supprimer un etudiant
        public void supprimerEtudiant(Long id){
            repository.deleteById(id);
        }

    }

