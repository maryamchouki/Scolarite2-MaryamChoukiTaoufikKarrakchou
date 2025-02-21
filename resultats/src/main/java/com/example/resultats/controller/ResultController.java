package com.example.resultats.controller;

import com.example.resultats.entity.Resultat;
import com.example.resultats.service.ResultatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ResultController {
private final ResultatService resultatService;
public ResultController(ResultatService resultatService) {
    this.resultatService = resultatService;
}
@GetMapping("/etudiant/{etudiantId}")
    public List<Resultat>getResultatByEtudiantId(@PathVariable Long etudiantId) {
    return resultatService.getResultatsByEtudiant(etudiantId);
}
    @GetMapping("/cours/{coursId}")
    public List<Resultat> getResultatsByCours(@PathVariable Long coursId) {
        return resultatService.getResultatsByCours(coursId);
    }
    @PostMapping("/cours")
    public Resultat saveResultat(@RequestBody Resultat resultat) {
        return resultatService.saveResultat(resultat);
    }
    @DeleteMapping("/{id}")
    public void deleteResultat(@PathVariable Long id) {
        resultatService.deleteResultat(id);
    }
}
