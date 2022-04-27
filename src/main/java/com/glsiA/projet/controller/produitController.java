package com.java.tp1.controller;

import com.java.tp1.modele.Produit;
import com.java.tp1.service.CategorieService;
import com.java.tp1.service.ProduitService;
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
