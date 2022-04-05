package com.glsiA.projet.controller;


import com.glsiA.projet.models.Approvisionement;
import com.glsiA.projet.models.Categorie;
import com.glsiA.projet.service.ApprovisionementService;
import com.glsiA.projet.service.CategorieService;
import org.apache.coyote.ajp.AbstractAjpProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/approvisionement")
public class ApprovisionementController {

    @Autowired
    private ApprovisionementService approvisionementService;


    @GetMapping("/afficher")
    public  String afficher(Model model)
    {
        model.addAttribute("list",approvisionementService.showallApprovisionement());
        return  "approvisionement/show";
    }

    @GetMapping("/create")
    public  String afficherFormulaire(){

        return  "approvisionement/formulaire";
    }
    @PostMapping("/save")
    public  String  save(Approvisionement approvisionement){
        //categorie.setDateCreation(LocalDate.now());
      //  approvisionement.setDateApprov(LocalDate.now());
        approvisionementService.saveApprovisionement(approvisionement);
        approvisionementService.updateProduit(approvisionement.getProduit().getId(),approvisionement.getQuantite());
        return  "redirect:/approvisionement/afficher";


    }

    @GetMapping("/edit/{id}")
    public  String formEdit(@PathVariable("id") int id, Model model){

        model.addAttribute("un",approvisionementService.showApprovisionement(id));

        return  "approvisionement/formEdit";
    }

    @PostMapping ("/edit")
    public  String edit(@ModelAttribute("un" ) Approvisionement approvisionement){
        approvisionementService.saveApprovisionement(approvisionement);
        return  "redirect:/approvisionement/afficher";
    }

    @GetMapping("/delete/{id}")
    public  String delete(@PathVariable("id") int id){
        approvisionementService.deleteApprovisionement(id);
        return  "redirect:/approvisionement/afficher";
    }
}
