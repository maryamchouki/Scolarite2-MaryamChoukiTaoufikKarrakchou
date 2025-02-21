package com.example.inscription.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name="inscription")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long etudiantId;
    private Long coursId;
}
