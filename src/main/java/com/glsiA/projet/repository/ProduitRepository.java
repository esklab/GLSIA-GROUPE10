package com.glsiA.projet.repository;


import com.glsiA.projet.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProduitRepository  extends JpaRepository <Produit, Integer> {


    @Query("FROM Produit where qteSeuil > qteStok")
    public List<Produit> produitRupture ();


    @Query("FROM Produit where libelle = ?1")
    public List<Produit> rechercher (String libelle);

    @Modifying
    @Transactional
    @Query(value = "update Produit a set a.qteStok = a.qteStok - :quantite where a.id = :id")
    public void updateProduit(@Param("id") Integer id, @Param("quantite") int quantite);
}
