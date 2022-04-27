package com.java.tp1.repository;

import com.java.tp1.modele.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository  extends JpaRepository <Produit, Integer> {
}
