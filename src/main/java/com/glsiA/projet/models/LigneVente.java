package com.glsiA.projet.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
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

    @ManyToOne()
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;
    private int userId;

}
