package com.glsiA.projet.service;

import com.glsiA.projet.models.Produit;
import com.glsiA.projet.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    public  void saveProduit(Produit produit){
        produitRepository.save(produit);
    }

    public  void rechercherProduit(String libelle){
        produitRepository.rechercher(libelle);
    }
    public  void updateStock (int id, int quantite){
        produitRepository.updateProduit(id,quantite);
    }

    public  void deleteProduit(int id){
        produitRepository.deleteById(id);
    }

    public List<Produit> showallProduit()
    {
        return  produitRepository.findAll();
    }

    public List<Produit> showallProduitRup()
    {
        return  produitRepository.produitRupture();
    }


    public Produit  showProduit( int id){
        Optional<Produit> optional =produitRepository.findById(id);
        Produit  produit = null;
        if(optional.isPresent())
        {
            produit = optional.get();
        }
        else
        {
            throw  new RuntimeException("id introuvable");
        }
        return  produit;
    }


}
