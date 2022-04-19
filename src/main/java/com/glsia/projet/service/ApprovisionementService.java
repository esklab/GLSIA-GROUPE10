package com.glsia.projet.service;

import com.glsia.projet.exception.UserNotFoundException;
import com.glsia.projet.modele.Approvisionement;
import com.glsia.projet.repository.ApprovisionementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ApprovisionementService {
    private final ApprovisionementRepository approvisionementRepository;

    @Autowired
    public ApprovisionementService(ApprovisionementRepository approvisionementRepository) {
        this.approvisionementRepository = approvisionementRepository;
    }

    public Approvisionement add (Approvisionement approvisionement ){
        approvisionement.setId(Integer.parseInt(UUID.randomUUID().toString()));
        return approvisionementRepository.save(approvisionement);
    }

    public List<Approvisionement> findAll(){
        return approvisionementRepository.findAll();
    }

    public Approvisionement update(Approvisionement approvisionement )
    {
        return approvisionementRepository.save(approvisionement);
    }

    public Approvisionement findById(int id){



        return approvisionementRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id "+ id + " was not found"));
    }

    public void delete(int id){
        approvisionementRepository.deleteById(id);
    }
}
