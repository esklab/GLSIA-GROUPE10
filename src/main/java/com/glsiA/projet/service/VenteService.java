package com.glsiA.projet.service;

import com.glsiA.projet.models.Vente;
import com.glsiA.projet.repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenteService {

    @Autowired
    private VenteRepository venteRepository;

    public  void saveVente(Vente vente){
        venteRepository.save(vente);


    }

    public  Vente lastSave(){
       return venteRepository.lastSave();
    }


    public  void deleteVente(int id){
        venteRepository.deleteById(id);
    }

    public List<Vente> showallVente()
    {
        return  venteRepository.findAll();
    }

    public Vente  showVente( int id){
        Optional<Vente> optional =venteRepository.findById(id);
        Vente  vente = null;
        if(optional.isPresent())
        {
            vente= optional.get();
        }
        else
        {
            throw  new RuntimeException("id introuvable");
        }
        return  vente;
    }

    
}
