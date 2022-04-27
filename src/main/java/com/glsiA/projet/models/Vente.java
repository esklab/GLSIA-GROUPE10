package com.java.tp1.modele;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "produits")
public class Vente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="libelle")
    private String libelle;



    @Column(name="date_creation")
    @CreationTimestamp
    private LocalDate dateCreation;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Categorie categorie;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit")
    private Set<Approvisionement> approvisionements;


}
