package com.fisa.bddgestion.service;

import com.fisa.bddgestion.exception.EntityNotFoundException;
import com.fisa.bddgestion.model.Groupe;
import com.fisa.bddgestion.repository.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class GroupeService {
    
    @Autowired
    private GroupeRepository groupeRepository;

    public Groupe creerGroupe(Groupe groupe) {
        if (groupe.getNumero() == null || groupe.getNumero().isEmpty()) {
            throw new IllegalArgumentException("Le numéro de groupe est obligatoire");
        }
        return groupeRepository.save(groupe);
    }

    public List<Groupe> getAllGroupes() {
        return groupeRepository.findAll();
    }

    public Groupe getGroupeByNumero(String numero) {
        return groupeRepository.findByNumero(numero);
    }

    public Groupe getGroupeById(String Id) {
        return groupeRepository.findById(Id)
                .orElseThrow(() -> new EntityNotFoundException("Groupe non trouvé"));
    }

    public List<Groupe> getGroupesByVille(String ville) {
        return groupeRepository.findByVille(ville);
    }

    public Groupe mettreAJourGroupe(Groupe groupe) {
        return groupeRepository.findById(groupe.getNumero())
                .map(existingGroup -> {
                    existingGroup.setNom(groupe.getNom());
                    existingGroup.setVille(groupe.getVille());
                    existingGroup.setCodePostal(groupe.getCodePostal());
                    return groupeRepository.save(existingGroup);
                }).orElseThrow();
    }

    public void supprimerGroupe(String id) {
        if (!groupeRepository.existsById(id)) {
            throw new EntityNotFoundException("Groupe non trouvé");
        }
        groupeRepository.deleteById(id);
    }
}
