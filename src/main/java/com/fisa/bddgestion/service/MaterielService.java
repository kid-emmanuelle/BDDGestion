package com.fisa.bddgestion.service;

import com.fisa.bddgestion.exception.EntityNotFoundException;
import com.fisa.bddgestion.model.Materiel;
import com.fisa.bddgestion.repository.MaterielRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterielService {
    @Autowired
    private MaterielRepository materielRepository;

    public Materiel ajouterMateriel(Materiel materiel) {
        if (materiel.getNumeroSerie() == null || materiel.getNumeroSerie().isEmpty()) {
            throw new IllegalArgumentException("Le numéro de série est obligatoire");
        }
        if (materiel.getNumeroGroupe() == null || materiel.getNumeroGroupe().isEmpty()) {
            throw new IllegalArgumentException("Le numéro de groupe est obligatoire");
        }
        return materielRepository.save(materiel);
    }

    public List<Materiel> getMaterielsByGroupe(String numeroGroupe) {
        return materielRepository.findByNumeroGroupe(numeroGroupe);
    }

    public Materiel getMaterielByNumeroSerie(String numeroSerie) {
        return materielRepository.findById(numeroSerie)
                .orElseThrow(() -> new EntityNotFoundException("Materiel non trouvé"));
    }
}