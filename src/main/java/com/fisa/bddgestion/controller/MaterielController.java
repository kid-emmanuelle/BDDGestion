package com.fisa.bddgestion.controller;

import com.fisa.bddgestion.model.Materiel;
import com.fisa.bddgestion.service.MaterielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materiels")
public class MaterielController {
    @Autowired
    private MaterielService materielService;

    @PostMapping
    public ResponseEntity<Materiel> ajouterMateriel(@RequestBody Materiel materiel) {
        return ResponseEntity.ok(materielService.ajouterMateriel(materiel));
    }

    @GetMapping("/groupe/{numeroGroupe}")
    public ResponseEntity<List<Materiel>> getMaterielsByGroupe(@PathVariable String numeroGroupe) {
        return ResponseEntity.ok(materielService.getMaterielsByGroupe(numeroGroupe));
    }

    @GetMapping("/{numeroSerie}")
    public ResponseEntity<Materiel> getMaterielByNumeroSerie(@PathVariable String numeroSerie) {
        return ResponseEntity.ok(materielService.getMaterielByNumeroSerie(numeroSerie));
    }

    @GetMapping
    public ResponseEntity<List<Materiel>> getMateriels() {
        return ResponseEntity.ok(materielService.getMateriels());
    }

    @PutMapping
    public ResponseEntity<Materiel> mettreAjourMateriel(@RequestBody Materiel materiel) {
        return ResponseEntity.ok(materielService.mettreAJourMateriel(materiel));
    }
}