package com.glsia.projet.repository;

import com.glsia.projet.modele.Approvisionement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "approvisionement",path = "approvisionement")
public interface ApprovisionementRepository extends JpaRepository<Approvisionement,Long> {
}
