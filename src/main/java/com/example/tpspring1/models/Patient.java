package com.example.tpspring1.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.management.ConstructorParameters;
import java.util.Collection;
import java.util.Date;
@Entity
@Data
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@ToString
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    private boolean malade;
    private int score;
    @OneToMany(mappedBy = "patient")
    private Collection<RendezVous> rendezVous;

}
