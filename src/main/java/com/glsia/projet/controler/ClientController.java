package com.glsia.projet.controler;


import com.glsia.projet.modele.Client;
import com.glsia.projet.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllCli (){
        List<Client> clients = clientService.findAll();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Client> getByIdCli (@PathVariable("id") int id){
        Client  client = clientService.findById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Client> addCli(@RequestBody Client client) {
        Client newClient = clientService.add(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Client> updateCli(@RequestBody Client client) {
        Client updateClient = clientService.update(client);
        return new ResponseEntity<>(updateClient, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCli(@PathVariable("id") int id) {
        clientService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
