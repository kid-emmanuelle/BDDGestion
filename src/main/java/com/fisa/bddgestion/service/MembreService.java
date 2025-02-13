package com.fisa.bddgestion.service;

import com.fisa.bddgestion.exception.EntityNotFoundException;
import com.fisa.bddgestion.model.Membre;
import com.fisa.bddgestion.repository.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembreService {
    @Autowired
    private MembreRepository membreRepository;

    public Membre inscrireMembre(Membre membre) {
        // Validation basique
        if (membre.getEmail() == null || membre.getEmail().isEmpty()) {
            throw new IllegalArgumentException("L'email est obligatoire");
        }
        if (membre.getNumeroGroupe() == null || membre.getNumeroGroupe().isEmpty()) {
            throw new IllegalArgumentException("Le numéro de groupe est obligatoire");
        }
        return membreRepository.save(membre);
    }

    public List<Membre> getAllMembres() {
        return membreRepository.findAll();
    }

    public Membre getMembreById(String id) {
        return membreRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Membre non trouvé"));
    }

    public List<Membre> getMembresByGroupe(String numeroGroupe) {
        return membreRepository.findByNumeroGroupe(numeroGroupe);
    }

    public boolean login(String email, String password) {
        return membreRepository.findByEmailAndPassword(email, password).isPresent();
    }
}