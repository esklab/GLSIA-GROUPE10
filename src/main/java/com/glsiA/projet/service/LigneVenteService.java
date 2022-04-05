package com.glsiA.projet.service;


import com.glsiA.projet.models.LigneVente;
import com.glsiA.projet.repository.LigneVenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LigneVenteService {

    @Autowired
    private LigneVenteRepository ligneVenteRepository;

    public  void saveLigneVente(LigneVente ligneVente){
        ligneVenteRepository.save(ligneVente);
    }

    public  void deleteLigneVente(int id){
        ligneVenteRepository.deleteById(id);
    }

    public List<LigneVente> showallLigneVente()
    {
        return  ligneVenteRepository.findAll();
    }

    public LigneVente  showLigneVente( int id){
        Optional<LigneVente> optional =ligneVenteRepository.findById(id);
        LigneVente  ligneVente = null;
        if(optional.isPresent())
        {
            ligneVente= optional.get();
        }
        else
        {
            throw  new RuntimeException("id introuvable");
        }
        return  ligneVente;
    }

    
}
