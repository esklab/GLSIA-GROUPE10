package com.glsia.projet.controler;


import com.glsia.projet.modele.LigneVente;
import com.glsia.projet.service.LigneVenteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lignevente")
public class LigneVenteController {
    private final LigneVenteService ligneVenteService;

    public LigneVenteController(LigneVenteService ligneVenteService) {
        this.ligneVenteService = ligneVenteService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<LigneVente>> getAllLigne (){
        List<LigneVente> ligneVentes = ligneVenteService.findAll();
        return new ResponseEntity<>(ligneVentes, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<LigneVente> getByIdLigne ( @PathVariable("id") int id){
        LigneVente  ligneVente = ligneVenteService.findById(id);
        return new ResponseEntity<>(ligneVente, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<LigneVente> addLigne(@RequestBody LigneVente ligneVente) {
        LigneVente newLigneVente = ligneVenteService.add(ligneVente);
        return new ResponseEntity<>(newLigneVente, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<LigneVente> updateLigne(@RequestBody LigneVente ligneVente) {
        LigneVente updateLigneVente = ligneVenteService.update(ligneVente);
        return new ResponseEntity<>(updateLigneVente, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteLigne(@PathVariable("id") int id) {
        ligneVenteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
