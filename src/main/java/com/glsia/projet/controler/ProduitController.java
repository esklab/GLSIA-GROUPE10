package com.glsia.projet.controler;


import com.glsia.projet.modele.Produit;
import com.glsia.projet.service.ProduitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produit")
public class ProduitController {
    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Produit>> getAllProd (){
        List<Produit> produits = produitService.findAll();
        return new ResponseEntity<>(produits, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Produit> getByIdProd ( @PathVariable("id") int id){
        Produit  produit = produitService.findById(id);
        return new ResponseEntity<>(produit, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Produit> addProd(@RequestBody Produit produit) {
        Produit newProduit = produitService.add(produit);
        return new ResponseEntity<>(newProduit, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Produit> updateProd(@RequestBody Produit produit) {
        Produit updateProduit = produitService.update(produit);
        return new ResponseEntity<>(updateProduit, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProd(@PathVariable("id") int id) {
        produitService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
