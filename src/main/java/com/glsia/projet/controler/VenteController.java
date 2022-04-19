package com.glsia.projet.controler;


import com.glsia.projet.modele.Vente;
import com.glsia.projet.service.VenteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vente")
public class VenteController {
    private final VenteService venteService;

    public VenteController(VenteService venteService) {
        this.venteService = venteService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Vente>> getAllVente (){
        List<Vente> ventes = venteService.findAll();
        return new ResponseEntity<>(ventes, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Vente> getByIdVente ( @PathVariable("id") int id){
        Vente  vente = venteService.findById(id);
        return new ResponseEntity<>(vente, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Vente> addVente(@RequestBody Vente vente) {
        Vente newVente = venteService.add(vente);
        return new ResponseEntity<>(newVente, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Vente> updateVente(@RequestBody Vente vente) {
        Vente updateVente = venteService.update(vente);
        return new ResponseEntity<>(updateVente, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVente(@PathVariable("id") int id) {
        venteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
