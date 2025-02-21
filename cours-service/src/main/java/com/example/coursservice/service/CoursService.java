package com.example.coursservice.service;

import com.example.coursservice.entity.Cours;
import com.example.coursservice.repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursService {
    @Autowired
    private CoursRepository coursRepository;
    //Ajouter un cours
    public Cours ajouterCours(Cours cours) {
        return coursRepository.save(cours);
    }
    //Recuperer un cours par ID
    public Optional<Cours> getCoursById(Long id) {
        return coursRepository.findById(id);
    }
    //Recuperer un cours par son nom
    public List<Cours> getCoursByName(String name){
        return coursRepository.findByName(name);
    }
    //Supprimer un cours
    public void supprimerCours(Long id){
        coursRepository.deleteById(id);
    }
    public List<Cours> getAllCours(){
        return coursRepository.findAll();
    }
}
