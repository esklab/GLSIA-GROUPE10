package com.glsiA.projet.repository;


import com.glsiA.projet.models.Produit;
import com.glsiA.projet.models.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenteRepository extends JpaRepository<Vente, Integer> {
    //@Query("FROM Vente where id != 0 ")
    @Query(value = "SELECT * FROM Vente ORDER BY id DESC LIMIT 1", nativeQuery = true)
    public Vente lastSave ();
}
