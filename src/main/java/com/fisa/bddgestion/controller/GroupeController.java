package com.fisa.bddgestion.controller;

import com.fisa.bddgestion.model.Groupe;
import com.fisa.bddgestion.service.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groupes")
public class GroupeController {
    @Autowired
    private GroupeService groupeService;

    @PostMapping
    public ResponseEntity<Groupe> creerGroupe(@RequestBody Groupe groupe) {
        return ResponseEntity.ok(groupeService.creerGroupe(groupe));
    }

    @GetMapping
    public ResponseEntity<List<Groupe>> getAllGroupes() {
        return ResponseEntity.ok(groupeService.getAllGroupes());
    }

    // find by id
    @GetMapping("/{id}")
    public ResponseEntity<Groupe> getGroupeById(@PathVariable String id) {
        return ResponseEntity.ok(groupeService.getGroupeById(id));
    }

    // find by numero
    @GetMapping("numero/{numero}")
    public ResponseEntity<Groupe> getGroupeByNumero(@PathVariable String numero) {
        return ResponseEntity.ok(groupeService.getGroupeByNumero(numero));
    }

    @GetMapping("/ville/{ville}")
    public ResponseEntity<List<Groupe>> getGroupesByVille(@PathVariable String ville) {
        return ResponseEntity.ok(groupeService.getGroupesByVille(ville));
    }

    @PutMapping
    public ResponseEntity<Groupe> mettreAJourGroupe(@RequestBody Groupe groupe) {
        return ResponseEntity.ok(groupeService.mettreAJourGroupe(groupe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerGroupe(@PathVariable String id) {
        groupeService.supprimerGroupe(id);
        return ResponseEntity.noContent().build();
    }
}