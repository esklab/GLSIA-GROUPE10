package com.glsiA.projet.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "approvisionement")
public class Approvisionement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name="quantite")
    private  int  quantite;

    @Column(name="date_creation")
    @CreationTimestamp
    private   LocalDate dateCreation;

    @ManyToOne
    @JoinColumn(name = "produit_id", nullable = false)
    private Produit produit;
   // private int produit_id;

}
