package com.fisa.bddgestion.repository;

import com.fisa.bddgestion.model.Commande;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface CommandeRepository extends MongoRepository<Commande, String> {
    List<Commande> findByIdVendeur(String idVendeur);
    List<Commande> findByDateCommandeBetween(Date debut, Date fin);

    List<Commande> findAllByIdClient(String clientid);
}