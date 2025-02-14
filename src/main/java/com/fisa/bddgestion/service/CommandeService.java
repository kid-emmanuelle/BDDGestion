package com.fisa.bddgestion.service;

import com.fisa.bddgestion.exception.EntityNotFoundException;
import com.fisa.bddgestion.model.Commande;
import com.fisa.bddgestion.repository.CommandeRepository;
import com.fisa.bddgestion.repository.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    public List<Commande> getAllCommande() {
        return commandeRepository.findAll();
    }

    public Commande getCommandeById(String id) {
        return commandeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Commande non trouvée"));
    }

    public List<Commande> getCommandeByClientId(String clientid) {
        return commandeRepository.findAllByIdClient(clientid);
    }

    public Commande creerGroupe(Commande commande) {
        if (commande.getId() == null || commande.getId().isEmpty()) {
            throw new IllegalArgumentException("Le numéro de groupe est obligatoire");
        }
        return commandeRepository.save(commande);
    }
}
