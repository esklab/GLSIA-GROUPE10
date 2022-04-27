package com.java.tp1.controller;


import com.java.tp1.modele.Categorie;

import com.java.tp1.service.CategorieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/categorie")
public class categorieController {

    @Autowired
    private CategorieService categorieService;


    @GetMapping("/afficher")
    public  String afficherCategorie(Model model)
    {
        model.addAttribute("listCategorie",categorieService.showallCategorie());
        return  "categorie/showCategorie";
    }

    @GetMapping("/create")
    public  String afficherFormulaire(){

        return  "categorie/formulaire";
    }
    @PostMapping("/save")
    public  String  save(Categorie  categorie){
        //categorie.setDateCreation(LocalDate.now());
        categorie.setDateCreation(LocalDate.now());
        categorieService.saveCategorie(categorie);
        return  "redirect:/categorie/afficher";
    }

    @GetMapping("/edit/{id}")
    public  String formEditCategorie(@PathVariable("id") int id, Model model){

        model.addAttribute("unCategorie",categorieService.showCategorie(id));

        return  "categorie/formEdit";
    }

    @PostMapping ("/edit")
    public  String edit(@ModelAttribute("unCategorie" ) Categorie categorie){
        categorieService.saveCategorie(categorie);
        return  "redirect:/categorie/afficher";
    }

    @GetMapping("/delete/{id}")
    public  String delete(@PathVariable("id") int id){

        categorieService.deleteCategorie(id);
        return  "redirect:/categorie/afficher";
    }

}
