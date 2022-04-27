package com.glsiA.projet.models;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="categorie")

/*@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor*/
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  int id;

    @Column(name="libelle")
    private  String libelle;


    @Column(name="date_creation")
    @CreationTimestamp
    private   LocalDate dateCreation;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorie")
    private Set<Produit> produits;

}



