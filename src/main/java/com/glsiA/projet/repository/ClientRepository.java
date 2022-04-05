package com.glsiA.projet.repository;

import com.glsiA.projet.models.Categorie;
import com.glsiA.projet.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
