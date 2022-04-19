package com.glsia.projet.controler;

import com.glsia.projet.modele.Categorie;
import com.glsia.projet.service.CategorieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorie")
public class CategorieController {

    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Categorie>> getAllCat (){
        List<Categorie> categories = categorieService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Categorie> getByIdCat ( @PathVariable("id") Long id){
        Categorie  categorie = categorieService.findById(id);
        return new ResponseEntity<>(categorie, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Categorie> addCat(@RequestBody Categorie categorie) {
        Categorie newCategorie = categorieService.add(categorie);
        return new ResponseEntity<>(newCategorie, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Categorie> updateCat(@RequestBody Categorie categorie) {
        Categorie updateCategorie = categorieService.update(categorie);
        return new ResponseEntity<>(updateCategorie, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCat(@PathVariable("id") Long id) {
         categorieService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
