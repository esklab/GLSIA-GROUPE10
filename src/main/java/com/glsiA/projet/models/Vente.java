package com.glsiA.projet.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
/*@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor*/
@Table(name = "vente")
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



    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "produit")
    private List<Approvisionement> approvisionements;
        */
    @ManyToOne()
    @JoinColumn(name = "client_id", nullable = false,insertable = false, updatable = false)
    private User client;
    private int client_id;
}
