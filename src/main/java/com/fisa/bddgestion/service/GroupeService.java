package com.fisa.bddgestion.service;

import com.fisa.bddgestion.exception.EntityNotFoundException;
import com.fisa.bddgestion.model.Groupe;
import com.fisa.bddgestion.repository.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return groupeRepository.findById(numero)
                .orElseThrow(() -> new EntityNotFoundException("Groupe non trouvé"));
    }
}