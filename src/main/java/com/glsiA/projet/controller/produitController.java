package com.glsiA.projet.controller;

import com.glsiA.projet.models.Produit;
import com.glsiA.projet.service.CategorieService;
import com.glsiA.projet.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;

@Controller
@RequestMapping("/produit")
public class produitController {
    @Autowired
    private ProduitService produitService;

    @Autowired
    private CategorieService categorieService;

    @GetMapping("/afficher")
    public  String afficherProduit(Model model)
    {
        //Model listProduit = model.addAllAttributes("listProduit", produitService.showallProduit());
       model.addAttribute("listProduit",produitService.showallProduit());


        return  "produit/showProduit";
    }

    @GetMapping("/rupture")
    public  String afficherProduitRup(Model model)
    {
        //Model listProduit = model.addAllAttributes("listProduit", produitService.showallProduit());
        model.addAttribute("listProduit",produitService.showallProduitRup());


        return  "produit/rupProduit";
    }

    @GetMapping("/create")
    public  String afficherFormulaire(Model  model){
        model.addAttribute("listCat",categorieService.showallCategorie());

        return  "produit/formulaire";
    }

    @PostMapping("/save")
    public  String  save(Produit produit){
        produit.setQteStok(0);
        produit.setDateCreation(LocalDate.now());
        produitService.saveProduit(produit);
        return  "redirect:/produit/afficher";
    }

    @GetMapping("/edit/{id}")
    public  String formEditProduit(@PathVariable("id") int id, Model model){
        model.addAttribute("listCat",categorieService.showallCategorie());
        model.addAttribute("unProduit",produitService.showProduit(id));

        return  "produit/formEdit";
    }

    @PostMapping ("/edit")
    public  String edit(@ModelAttribute("unProduit" ) Produit produit){


        produitService.saveProduit(produit);
        return  "redirect:/produit/afficher";
    }

    @GetMapping("/delete/{id}")
    public  String delete(@PathVariable("id") int id){


        produitService.deleteProduit(id);
        return  "redirect:/produit/afficher";
    }
}
