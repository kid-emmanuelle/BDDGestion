package com.fisa.bddgestion.repository;

import com.fisa.bddgestion.model.Groupe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroupeRepository extends MongoRepository<Groupe, String> {
    Groupe findByNom(String nom);
}