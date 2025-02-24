package com.fisa.bddgestion.service;

import com.fisa.bddgestion.exception.EntityNotFoundException;
import com.fisa.bddgestion.model.Commande;
import com.fisa.bddgestion.model.Materiel;
import com.fisa.bddgestion.repository.MaterielRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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

    public List<Materiel> getMateriels() {
        return materielRepository.findAll();
    }

    public Materiel mettreAJourMateriel(Materiel materiel) {
        return materielRepository.findById(materiel.getNumeroSerie())
                .map(existingGroup -> {
                    existingGroup.setNumeroGroupe(materiel.getNumeroGroupe());
                    existingGroup.setNumeroSerie(materiel.getNumeroSerie());
                    existingGroup.setPrix(materiel.getPrix());
                    existingGroup.setMarque(materiel.getMarque());
                    existingGroup.setModele(materiel.getModele());
                    return materielRepository.save(existingGroup);
                }).orElseThrow();
    }

    public List<Materiel> getMaterielsById(String numeroSerie, String marque, Double price) {
        System.out.println(numeroSerie);
        if (marque == null && price == null) {
            return materielRepository.findAllByNumeroSerie(numeroSerie);
        }
        return materielRepository.findAllByNumeroSerieAndMarqueOrPrix(numeroSerie, marque, price);
    }

    public void supprimerMateriel(String id) {
        if (!materielRepository.existsById(id)) {
            throw new EntityNotFoundException("Materiel non trouvé");
        }
        materielRepository.deleteById(id);
    }
}