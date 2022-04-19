package com.glsia.projet.service;


import com.glsia.projet.exception.UserNotFoundException;
import com.glsia.projet.modele.Produit;
import com.glsia.projet.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProduitService {

    private final ProduitRepository produitRepository;

    @Autowired
    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public Produit add (Produit produit ){
        produit.setId(Integer.parseInt(UUID.randomUUID().toString()));
        return produitRepository.save(produit);
    }

    public List<Produit> findAll(){
        return produitRepository.findAll();
    }

    public Produit update(Produit produit )
    {
        return produitRepository.save(produit);
    }

    public Produit findById(int id){



        return produitRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id "+ id + " was not found"));
    }

    public void delete(int id){
        produitRepository.deleteById(id);
    }

}
