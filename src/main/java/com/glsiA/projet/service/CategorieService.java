package com.glsiA.projet.service;

import com.glsiA.projet.models.Categorie;

import com.glsiA.projet.repository.CategorieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;

    public  void saveCategorie(Categorie categorie){
        categorieRepository.save(categorie);
    }

    public  void deleteCategorie(int id){
        categorieRepository.deleteById(id);
    }

    public List<Categorie> showallCategorie()
    {
        return  categorieRepository.findAll();
    }

    public Categorie  showCategorie( int id){
        Optional<Categorie> optional =categorieRepository.findById(id);
        Categorie  categorie = null;
        if(optional.isPresent())
        {
            categorie= optional.get();
        }
        else
        {
            throw  new RuntimeException("id introuvable");
        }
        return  categorie;
    }

}
