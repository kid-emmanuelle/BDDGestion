package com.fisa.bddgestion.controller;

import com.fisa.bddgestion.model.Commande;
import com.fisa.bddgestion.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @GetMapping
    public ResponseEntity<List<Commande>> getAllCommandes() {
        return ResponseEntity.ok(this.commandeService.getAllCommande());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommandeById(@RequestParam String id) {
        return ResponseEntity.ok(this.commandeService.getCommandeById(id));
    }

    @GetMapping("/client/{clientid}")
    public ResponseEntity<List<Commande>> getCommandeByClientId(@PathVariable String clientid) {
        return ResponseEntity.ok(this.commandeService.getCommandeByClientId(clientid));
    }

    @PostMapping
    public ResponseEntity<Commande> addCommande(@RequestBody Commande commande) {
        return ResponseEntity.ok(commandeService.creerGroupe(commande));
    }
}
