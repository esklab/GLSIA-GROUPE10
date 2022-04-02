package com.glsia.projet.modele;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
//@Getter
//@Setter

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vente")
public class Vente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @Column(name="date_creation")
    @CreationTimestamp
    private LocalDate dateCreation;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit")
    private Set<LigneVente> ligneVentes;


    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

}
