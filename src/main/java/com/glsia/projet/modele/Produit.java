package com.glsia.projet.modele;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter

//@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="libelle")
    private String libelle;

    @Column(name="qte_stock")
    private int qteStok;

    @Column(name="qte_seuil")
    private int qteSeuil;

    @Column(name="prix")
    private int prix;

    @Column(name="date_creation")
    @CreationTimestamp
    private LocalDate dateCreation;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Categorie categorie;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit")
    private Set<Approvisionement> approvisionements;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit")
    private Set<LigneVente> ligneVentes;


}
