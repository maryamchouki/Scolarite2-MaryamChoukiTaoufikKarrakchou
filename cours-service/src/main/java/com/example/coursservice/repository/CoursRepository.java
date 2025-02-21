package com.example.coursservice.repository;

import com.example.coursservice.entity.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursRepository extends JpaRepository<Cours, Long> {
    List<Cours> findByName(String name);
}
