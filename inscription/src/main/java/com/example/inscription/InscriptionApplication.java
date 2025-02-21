package com.example.inscription;

import com.example.inscription.entity.Inscription;
import com.example.inscription.repository.InscriptionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InscriptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(InscriptionApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(InscriptionRepository inscriptionRepository) {
        return args -> {
            // Créer et sauvegarder des inscriptions
            Inscription i1 = Inscription.builder()
                    .etudiantId(1L)
                    .coursId(101L)
                    .build();
            inscriptionRepository.save(i1);

            Inscription i2 = Inscription.builder()
                    .etudiantId(2L)
                    .coursId(102L)
                    .build();
            inscriptionRepository.save(i2);
            // Récupérer une inscription par ID
            Inscription inscription = inscriptionRepository.findById(1L).orElse(null);
            if (inscription != null) {
                System.out.println("inscription récupérée : Étudiant ID " + inscription.getEtudiantId() + ",Cours ID" + inscription.getCoursId());
            } else {
                System.out.println("Aucune inscription trouvée avec l'ID 1.");
            }
                // Afficher toutes les inscriptions
            System.out.println("Toutes les inscriptions:");
            inscriptionRepository.findAll().forEach(System.out::println);
                // Supprimer une inscription par ID
            inscriptionRepository.deleteById(2L);
            System.out.println("Inscriptions après suppression de l'ID 2 :");
            inscriptionRepository.findAll().forEach(System.out::println);
        };
    }
}
