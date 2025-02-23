package com.fisa.bddgestion.controller;

import com.fisa.bddgestion.model.Commande;
import com.fisa.bddgestion.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Commande> getCommandeById(@PathVariable String id) {
        return ResponseEntity.ok(this.commandeService.getCommandeById(id));
    }

    @PostMapping
    public ResponseEntity<Commande> addCommande(@RequestBody Commande commande) {
        return ResponseEntity.ok(this.commandeService.creerGroupe(commande));
    }

    @GetMapping("/search/date")
    public ResponseEntity<List<Commande>> getCommandeByDate(@RequestParam String start, @RequestParam String end) {
        return ResponseEntity.ok(this.commandeService.getCommandeByDate(start, end));
    }

    @GetMapping("/search/client/{clientid}")
    public ResponseEntity<List<Commande>> getCommandebyClientId(@PathVariable String clientid, @RequestParam(required = false) String idVendeur, @RequestParam(required = false) Double price) {
        return ResponseEntity.ok(this.commandeService.getCommandeByClientId(clientid, idVendeur, price));
    }

    @GetMapping("/search/vendeur/{vendeurid}")
    public ResponseEntity<List<Commande>> getCommandebyVendeurId(@PathVariable String vendeurid, @RequestParam(required = false) String idClient, @RequestParam(required = false) Double price) {
        return ResponseEntity.ok(this.commandeService.getCommandeByVendeurId(vendeurid, idClient, price));
    }
}
