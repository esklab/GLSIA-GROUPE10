package com.glsia.projet.controler;


import com.glsia.projet.modele.Approvisionement;
import com.glsia.projet.service.ApprovisionementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/approvisionement")
public class ApprovisionementController {

    private final ApprovisionementService approvisionementService;

    public ApprovisionementController(ApprovisionementService approvisionementService) {
        this.approvisionementService = approvisionementService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Approvisionement>> getAllAppro (){
        List<Approvisionement> approvisionements = approvisionementService.findAll();
        return new ResponseEntity<>(approvisionements, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Approvisionement> getByIdAppro ( @PathVariable("id") int id){
        Approvisionement  approvisionement = approvisionementService.findById(id);
        return new ResponseEntity<>(approvisionement, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Approvisionement> addAppro (@RequestBody Approvisionement approvisionement) {
        Approvisionement newApprovisionement = approvisionementService.add(approvisionement);
        return new ResponseEntity<>(newApprovisionement, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Approvisionement> updateAppro(@RequestBody Approvisionement approvisionement) {
        Approvisionement updateApprovisionement = approvisionementService.update(approvisionement);
        return new ResponseEntity<>(updateApprovisionement, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAppro (@PathVariable("id") int id) {
        approvisionementService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
