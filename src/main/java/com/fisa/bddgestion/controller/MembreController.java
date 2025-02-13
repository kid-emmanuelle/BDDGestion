package com.fisa.bddgestion.controller;

import com.fisa.bddgestion.model.Membre;
import com.fisa.bddgestion.service.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/membres")
public class MembreController {
    @Autowired
    private MembreService membreService;

    @PostMapping
    public ResponseEntity<Membre> inscrireMembre(@RequestBody Membre membre) {
        return ResponseEntity.ok(membreService.inscrireMembre(membre));
    }

    @GetMapping
    public ResponseEntity<List<Membre>> getAllMembres() {
        return ResponseEntity.ok(membreService.getAllMembres());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Membre> getMembreById(@PathVariable String id) {
        return ResponseEntity.ok(membreService.getMembreById(id));
    }

    @GetMapping("/groupe/{numeroGroupe}")
    public ResponseEntity<List<Membre>> getMembresByGroupe(@PathVariable String numeroGroupe) {
        return ResponseEntity.ok(membreService.getMembresByGroupe(numeroGroupe));
    }

    @PostMapping("/login/{username}/{password}")
    public boolean login(@PathVariable String username, @PathVariable String password) {
        return this.membreService.login(username, password);
    }
}