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
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name="nom")
    private String nom;

    @Column(name="prenom")
    private String prenom;


    @Column(name="adresse")
    private String adresse;


    @Column(name="telephone")
    private String telephone;

    @Column(name="date_creation")
    @CreationTimestamp
    private   LocalDate dateCreation;



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Set<Vente> ventes;

}
