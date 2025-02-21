package com.example.etudiantservice;

import com.example.etudiantservice.entity.Etudiant;
import com.example.etudiantservice.repository.EtudiantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;




@SpringBootApplication
public class EtudiantServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtudiantServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(EtudiantRepository etudiantRepository) {
        return (args) -> {
            Etudiant e1 = Etudiant.builder()
                    .nom("Karrakchou")
                    .prenom("Taoufik")
                    .email("taoufik.karrakchou@gmail.com")
                    .dateNaissance("Janvier")
                    .build();
            etudiantRepository.save(e1);

            Etudiant e2 = Etudiant.builder()
                    .nom("chouki")
                    .prenom("Maryam")
                    .email("maryam.chouki@gmail.com")
                    .dateNaissance("Avril")
                    .build();
            etudiantRepository.save(e2);

            Etudiant e =etudiantRepository.findById(2L).get();
            System.out.println("Nom "+e.getNom());

        };
    }
}
