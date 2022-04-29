package com.glsiA.projet.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
/*
@Entity
*/
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "lignevente")
public class LigneVente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name="quantite")
    private  int  quantite;

    @Column(name="facturer")
    private  boolean  facturer;


    @Column(name="date_creation")
    @CreationTimestamp
    private   LocalDate dateCreation;



    @ManyToOne
    @JoinColumn(name = "produit_id", nullable = false, insertable = false, updatable = false)
    private Produit produit;
    private int produit_id;

    @ManyToOne
    @JoinColumn(name = "vente_id", nullable = false,  insertable = false, updatable = false)
    private Vente vente;
    private int vente_id;



}
