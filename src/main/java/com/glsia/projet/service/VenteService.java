package com.glsia.projet.service;

import com.glsia.projet.exception.UserNotFoundException;
import com.glsia.projet.modele.Vente;
import com.glsia.projet.repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VenteService {

    private final VenteRepository venteRepository;

    @Autowired
    public VenteService(VenteRepository venteRepository) {
        this.venteRepository = venteRepository;
    }

    public Vente add (Vente vente ){
        vente.setId(Integer.parseInt(UUID.randomUUID().toString()));
        return venteRepository.save(vente);
    }

    public List<Vente> findAll(){
        return venteRepository.findAll();
    }

    public Vente update(Vente vente )
    {
        return venteRepository.save(vente);
    }

    public Vente findById(int id){



        return venteRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id "+ id + " was not found"));
    }

    public void delete(int id){
        venteRepository.deleteById(id);
    }
}
