package com.glsiA.projet.repository;


import com.glsiA.projet.models.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenteRepository extends JpaRepository<Vente, Integer> {
}
