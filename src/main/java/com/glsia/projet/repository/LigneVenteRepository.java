package com.glsia.projet.repository;

import com.glsia.projet.modele.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

//@CrossOrigin("http://localhost:4200")
//@RepositoryRestResource(collectionResourceRel = "lignevente",path = "lignevente")
@Repository
public interface LigneVenteRepository extends JpaRepository<LigneVente,Integer> {
}
