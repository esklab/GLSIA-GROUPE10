package com.glsiA.projet.controller;


import com.glsiA.projet.models.Approvisionement;
import com.glsiA.projet.models.Categorie;
import com.glsiA.projet.models.Produit;
import com.glsiA.projet.service.ApprovisionementService;
import com.glsiA.projet.service.CategorieService;
import com.glsiA.projet.service.ProduitService;
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
    @Autowired
    private ProduitService produitService;

   // @Autowired
    private  int ida;

    @GetMapping("/afficher")
    public  String afficher(Model model)
    {
        model.addAttribute("list",approvisionementService.showallApprovisionement());
        return  "approvisionement/show";
    }

    @GetMapping("/create/{id}")
    public  String afficherFormulaire(@PathVariable("id") int id, Model model){
        model.addAttribute("produit", produitService.showProduit(id));
        return  "approvisionement/formulaire";
    }
    @PostMapping("/save")
    public  String  save(Approvisionement approvisionement){
        //categorie.setDateCreation(LocalDate.now());
      //  approvisionement.setDateApprov(LocalDate.now());
        approvisionementService.saveApprovisionement(approvisionement);
        approvisionementService.updateProduit(approvisionement.getProduit_id(),approvisionement.getQuantite());
        return  "redirect:/produit/afficher";

    }

    @GetMapping("/edit/{id}")
    public  String formEdit(@PathVariable("id") int id, Model model){
        ida= 0;
        model.addAttribute("prod",approvisionementService.showApprovisionement(id));
        ida= approvisionementService.showApprovisionement(id).getQuantite();
        return  "approvisionement/formEdit";
    }

    @PostMapping ("/edit")
    public  String edit(@ModelAttribute("prod" ) Approvisionement approvisionement){
       approvisionementService.saveApprovisionement(approvisionement);
        approvisionementService.updateProduitMod(approvisionement.getProduit_id(),approvisionement.getQuantite(),ida);

        return  "redirect:/approvisionement/afficher";
    }

    @GetMapping("/delete/{id}")
    public  String delete(@PathVariable("id") int id){
        Approvisionement a = approvisionementService.showApprovisionement(id);
        approvisionementService.updateProduitDel(a.getProduit_id(),a.getQuantite());
        approvisionementService.deleteApprovisionement(id);
        return  "redirect:/approvisionement/afficher";
    }
}
