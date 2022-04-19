package com.glsia.projet.service;


import com.glsia.projet.exception.UserNotFoundException;
import com.glsia.projet.modele.LigneVente;
import com.glsia.projet.repository.LigneVenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LigneVenteService {
    private final LigneVenteRepository ligneVenteRepository;

    @Autowired
    public LigneVenteService(LigneVenteRepository ligneVenteRepository) {
        this.ligneVenteRepository = ligneVenteRepository;
    }

    public LigneVente add (LigneVente ligneVente ){
        ligneVente.setId(Integer.parseInt(UUID.randomUUID().toString()));
        return ligneVenteRepository.save(ligneVente);
    }

    public List<LigneVente> findAll(){
        return ligneVenteRepository.findAll();
    }

    public LigneVente update(LigneVente ligneVente )
    {
        return ligneVenteRepository.save(ligneVente);
    }

    public LigneVente findById(int id){



        return ligneVenteRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id "+ id + " was not found"));
    }

    public void delete(int id){
        ligneVenteRepository.deleteById(id);
    }
}
