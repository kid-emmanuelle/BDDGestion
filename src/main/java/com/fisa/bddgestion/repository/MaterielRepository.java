package com.fisa.bddgestion.repository;

import com.fisa.bddgestion.model.Materiel;
import com.fisa.bddgestion.model.TypeMateriel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MaterielRepository extends MongoRepository<Materiel, String> {
    List<Materiel> findByNumeroGroupe(String numeroGroupe);
    List<Materiel> findByType(TypeMateriel type);
}