package com.fisa.bddgestion.repository;

import com.fisa.bddgestion.model.Commande;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface CommandeRepository extends MongoRepository<Commande, String> {

    List<Commande> findByDateCommandeBetween(Date debut, Date fin);

    List<Commande> findAllByIdClient(String singleton);

    List<Commande> findAllByIdClientAndIdVendeurOrPrixTotal(String clientid, String idVendeur, Double price);

    List<Commande> findAllByIdVendeur(String vendeurid);

    List<Commande> findAllByIdVendeurAndIdClientOrPrixTotal(String vendeurid, String clientid, Double price);
}