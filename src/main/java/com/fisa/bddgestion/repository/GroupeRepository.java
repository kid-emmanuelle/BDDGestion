package com.fisa.bddgestion.repository;

import com.fisa.bddgestion.model.Groupe;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GroupeRepository extends MongoRepository<Groupe, String> {
    Groupe findByNom(String nom);
    List<Groupe> findByVille(String ville);
}