package com.glsiA.projet.repository;


import com.glsiA.projet.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProduitRepository  extends JpaRepository <Produit, Integer> {


    @Query("FROM Produit where qteSeuil > qteStok")
    public List<Produit> produitRupture ();
}
