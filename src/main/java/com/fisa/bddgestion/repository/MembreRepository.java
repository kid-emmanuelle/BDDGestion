package com.fisa.bddgestion.repository;

import com.fisa.bddgestion.model.Membre;
import com.fisa.bddgestion.model.TypeMembre;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MembreRepository extends MongoRepository<Membre, String> {
    List<Membre> findByNumeroGroupe(String numeroGroupe);
    List<Membre> findByType(TypeMembre type);
}