package com.glsia.projet.repository;

import com.glsia.projet.modele.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "vente",path = "vente")
public interface VenteRepository extends JpaRepository<Vente,Long> {
}
