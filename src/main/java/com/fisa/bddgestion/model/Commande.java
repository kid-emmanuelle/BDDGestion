package com.fisa.bddgestion.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "commandes")
public class Commande {
    @Id
    private String id;
    private String idClient;
    private String idVendeur;
    private Date dateCommande;
    private List<String> numerosSerie;  // Liste des numéros de série des matériels
    private Double prixTotal;
    private String numeroSerie;

}