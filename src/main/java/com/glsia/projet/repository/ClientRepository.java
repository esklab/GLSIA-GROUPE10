package com.glsia.projet.repository;


import com.glsia.projet.modele.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

//@CrossOrigin("http://localhost:4200")
//@RepositoryRestResource(collectionResourceRel = "client",path = "client")
@Repository
public interface ClientRepository  extends JpaRepository<Client,Integer> {
}
