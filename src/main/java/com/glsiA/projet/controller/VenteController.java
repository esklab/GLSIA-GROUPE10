package com.glsiA.projet.controller;

import com.glsiA.projet.models.*;
import com.glsiA.projet.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/vente")
public class VenteController {
    @Autowired
    private VenteService venteService;

    @Autowired
    private LigneVenteService ligneVenteService;


    @Autowired
    private ProduitService produitService;

    @Autowired
    private UserService userService;

    List<LigneVente> ligneVente = new ArrayList<>();
    List<Produit> listtwo =  new ArrayList<>();

    List<VenteDto> listtree = new ArrayList<>();
    ListVenteDto listfour = new ListVenteDto();

    @GetMapping("/afficher")
    public  String afficherVente(Model model)
    {
        model.addAttribute("listVente",venteService.showallVente());
        return  "vente/showVente";
    }

    @GetMapping("/create")
    public  String afficherFormulaire(Model model){
        VenteDto one =  new VenteDto();
        model.addAttribute("listProduit",produitService.showallProduit());
       // ligneVente = ligneVenteService.showallLigneVente();
        listtwo.removeAll( listtwo);
        //listtwo.venteDtoList.removeAll(listtwo.getVenteDtoList());
        listtree.removeAll(listtree);
        listfour.venteDtoList.removeAll(listtree);
        if(!ligneVente.isEmpty())
        {
        for (int i = 0; i < ligneVente.size(); i++) {
            listtwo.add(ligneVente.get(i).getProduit());
            one.setProduit(ligneVente.get(i).getProduit());
            one.setQuantite(ligneVente.get(i).getQuantite());
            listtree.add(one);

        }
        }


        listfour.venteDtoList.addAll(listtree);
        model.addAttribute("listLigne",listtwo);
        model.addAttribute("listTotal",listfour.getTotal());

        //listtree.get(1).produit.getLibelle()

        return  "vente/formulaire";
    }

    @GetMapping("/creat/{id}")
    public  String  afficher(@PathVariable("id") int id){
        boolean abc = false;

        for (int i = 0; i < ligneVente.size(); i++) {
            if (ligneVente.get(i).getProduit().getId() == id) {
                abc= true;
            }
        }

        if(abc == false){
            Produit pro = produitService.showProduit(id);
        LigneVente aaz= new LigneVente();
        aaz.setQuantite(1);
        aaz.setProduit(pro);
        ligneVente.add(aaz);
        }

        return  "redirect:/vente/create";
    }

    @GetMapping("/remo/{id}")
    public  String  affiche(@PathVariable("id") int id){
        boolean abc = false;
        Produit pro = produitService.showProduit(id);
        for (int i = 0; i < ligneVente.size(); i++) {
            if (ligneVente.get(i).getProduit().getId() == id) {
                ligneVente.remove(i);
            }
        }


        return  "redirect:/vente/create";
    }

    @PostMapping("/quante")
    public  String  save(Validate validate){
        return  "redirect:/vente/create";
    }

    @PostMapping("/save")
    public  String  save(Vente vente){
        //vente.setDateCreation(LocalDate.now());
        vente.setDateCreation(LocalDate.now());
        venteService.saveVente(vente);
        return  "redirect:/vente/afficher";
    }

    @GetMapping("/edit/{id}")
    public  String formEditVente(@PathVariable("id") int id, Model model){

        model.addAttribute("unVente",venteService.showVente(id));

        return  "vente/formEdit";
    }

    @PostMapping ("/edit")
    public  String edit(@ModelAttribute("unVente" ) Vente vente){
        venteService.saveVente(vente);
        return  "redirect:/vente/afficher";
    }

    @GetMapping("/delete/{id}")
    public  String delete(@PathVariable("id") int id){

        venteService.deleteVente(id);
        return  "redirect:/vente/afficher";
    }
}
