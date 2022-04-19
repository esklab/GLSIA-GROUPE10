package com.glsia.projet.service;

import com.glsia.projet.exception.UserNotFoundException;
import com.glsia.projet.modele.Categorie;
import com.glsia.projet.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategorieService {
    private final CategorieRepository categorieRepository;

    @Autowired
    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public Categorie add (Categorie categorie ){
        categorie.setId(Long.parseLong(UUID.randomUUID().toString()));
        return categorieRepository.save(categorie);
    }

    public List<Categorie> findAll(){
        return categorieRepository.findAll();
    }

    public Categorie update(Categorie categorie )
    {
        return categorieRepository.save(categorie);
    }

    public Categorie findById(Long id){



        return categorieRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id "+ id + " was not found"));
    }

    public void delete(Long id){
        categorieRepository.deleteById(id);
    }
}
