package com.example.coursservice;

import com.example.coursservice.entity.Cours;
import com.example.coursservice.repository.CoursRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CoursServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoursServiceApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(CoursRepository coursRepository) {
        return (args) -> {
            Cours c1=Cours.builder()
                    .name("Mathematique")
                    .description("Cours de mathématiques avancé")
                    .build();
          coursRepository.save(c1);

            Cours c2= Cours.builder()
                    .name("Informatique")
                    .description("Introduction à la programmation Logique")
                    .build();
            coursRepository.save(c2);

            Cours cours =coursRepository.findById(2L).get();
            System.out.println("name "+cours.getName());
            };
        }
    }


