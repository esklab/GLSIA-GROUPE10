package com.glsia.projet.modele;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter

//@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lignevente")
public class LigneVente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name="quantite")
    private  int  quantite;

    @Column(name="date_creation")
    @CreationTimestamp
    private   LocalDate dateCreation;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Produit produit;

    @ManyToOne
    @JoinColumn(name = "vente_id", nullable = false)
    private Vente vente;

}
