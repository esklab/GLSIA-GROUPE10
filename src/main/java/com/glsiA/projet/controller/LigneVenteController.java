package com.glsiA.projet.controller;


import com.glsiA.projet.models.LigneVente;
import com.glsiA.projet.service.LigneVenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/lignevente")
public class LigneVenteController {

    @Autowired
    private LigneVenteService ligneVenteService;


    @GetMapping("/afficher")
    public  String afficherLigneVente(Model model)
    {
        model.addAttribute("listLigneVente",ligneVenteService.showallLigneVente());
        return  "ligneVente/showLigneVente";
    }

    @GetMapping("/create")
    public  String afficherFormulaire(){

        return  "ligneVente/formulaire";
    }
    @PostMapping("/save")
    public  String  save(LigneVente ligneVente){
        //ligneVente.setDateCreation(LocalDate.now());
        ligneVente.setDateCreation(LocalDate.now());
        ligneVenteService.saveLigneVente(ligneVente);
        return  "redirect:/ligneVente/afficher";
    }

    @GetMapping("/edit/{id}")
    public  String formEditLigneVente(@PathVariable("id") int id, Model model){

        model.addAttribute("unLigneVente",ligneVenteService.showLigneVente(id));

        return  "ligneVente/formEdit";
    }

    @PostMapping ("/edit")
    public  String edit(@ModelAttribute("unLigneVente" ) LigneVente ligneVente){
        ligneVenteService.saveLigneVente(ligneVente);
        return  "redirect:/ligneVente/afficher";
    }

    @GetMapping("/delete/{id}")
    public  String delete(@PathVariable("id") int id){

        ligneVenteService.deleteLigneVente(id);
        return  "redirect:/ligneVente/afficher";
    }
}
