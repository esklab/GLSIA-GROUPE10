package com.glsia.projet.repository;

import com.glsia.projet.modele.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

//@CrossOrigin("http://localhost:4200")
//@RepositoryRestResource(collectionResourceRel = "categorie",path = "categorie")
@Repository
public interface CategorieRepository  extends JpaRepository<Categorie,Long> {

}
