package com.fisa.bddgestion.repository;

import com.fisa.bddgestion.model.Commande;
import com.fisa.bddgestion.model.Materiel;
import com.fisa.bddgestion.model.TypeMateriel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MaterielRepository extends MongoRepository<Materiel, String> {
    List<Materiel> findByNumeroGroupe(String numeroGroupe);
    List<Materiel> findByType(TypeMateriel type);


    List<Materiel> findAllByNumeroSerie(String numeroSerie);

    List<Materiel> findAllByNumeroSerieAndMarqueOrPrix(String materielId, String marque, Double price);

}