package com.example.resultats;

import com.example.resultats.entity.Resultat;
import com.example.resultats.repository.ResultatRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ResultatsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResultatsApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ResultatRepository resultatRepository) {
        return args -> {
            //// Ajouter des résultats
            Resultat r1 = Resultat.builder()

                    .etudiantId(1L)
                    .coursId(101L)
                    .note(15.5)
                    .build();
            resultatRepository.save(r1);

            Resultat r2 = Resultat.builder()
                    .etudiantId(2L)
                    .coursId(102L)
                    .note(18.0)
                    .build();
            resultatRepository.save(r2);
            //Récupérer et afficher un résultat
            Resultat r = resultatRepository.findById(2L).orElse(null);
            if (r != null) {
                System.out.println("Note de  l'étudiant " + r.getEtudiantId() + " : " + r.getNote());
            }
        };
    }
}
