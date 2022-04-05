package com.glsiA.projet.service;

import com.glsiA.projet.models.Approvisionement;
import com.glsiA.projet.models.Categorie;
import com.glsiA.projet.repository.ApprovisionementRepository;
import com.glsiA.projet.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApprovisionementService {
    @Autowired
    private ApprovisionementRepository approvisionementRepository;

    public  void saveApprovisionement(Approvisionement approvisionement){
        approvisionementRepository.save(approvisionement);
    }

    public  void updateProduit (int id, int quantite){
        approvisionementRepository.updateProduit(id,quantite);
    }

    public  void deleteApprovisionement(int id){
        approvisionementRepository.deleteById(id);
    }

    public List<Approvisionement> showallApprovisionement()
    {
        return  approvisionementRepository.findAll();
    }

    public Approvisionement  showApprovisionement( int id){
        Optional<Approvisionement> optional =approvisionementRepository.findById(id);
        Approvisionement  approvisionement = null;
        if(optional.isPresent())
        {
            approvisionement= optional.get();
        }
        else
        {
            throw  new RuntimeException("id introuvable");
        }
        return  approvisionement;
    }

}
