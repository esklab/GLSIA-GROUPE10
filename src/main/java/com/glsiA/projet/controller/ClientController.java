package com.glsiA.projet.controller;

import com.glsiA.projet.models.Client;
import com.glsiA.projet.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;


    @GetMapping("/afficher")
    public  String afficherClient(Model model)
    {
        model.addAttribute("listClient",clientService.showallClient());
        return  "client/showClient";
    }

    @GetMapping("/create")
    public  String afficherFormulaire(){

        return  "client/formulaire";
    }
    @PostMapping("/save")
    public  String  save(Client client){
        //client.setDateCreation(LocalDate.now())
        clientService.saveClient(client);
        return  "redirect:/client/afficher";
    }

    @GetMapping("/edit/{id}")
    public  String formEditClient(@PathVariable("id") int id, Model model){

        model.addAttribute("unClient",clientService.showClient(id));

        return  "client/formEdit";
    }

    @PostMapping ("/edit")
    public  String edit(@ModelAttribute("unClient" ) Client client){
        clientService.saveClient(client);
        return  "redirect:/client/afficher";
    }

    @GetMapping("/delete/{id}")
    public  String delete(@PathVariable("id") int id){

        clientService.deleteClient(id);
        return  "redirect:/client/afficher";
    }

}
