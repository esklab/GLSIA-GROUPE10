package com.java.tp1.service;

import com.java.tp1.modele.Approvisionement;
import com.java.tp1.modele.Categorie;
import com.java.tp1.repository.ApprovisionementRepository;
import com.java.tp1.repository.CategorieRepository;
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
