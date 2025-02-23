package com.fisa.bddgestion.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "groupes")
public class Groupe {
    @Id
    private String id;
    private String numero;  // G1, G2, etc.
    private String nom;
    private String ville;
    private String codePostal;
}