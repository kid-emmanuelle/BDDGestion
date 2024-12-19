package com.fisa.bddgestion.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "membres")
public class Membre {
    @Id
    private String id;
    private String nom;
    private String prenom;
    private String numeroRue;
    private String rue;
    private String ville;
    private String codePostal;
    private String email;
    private TypeMembre type;  // ACTIF ou CLIENT
    private String numeroGroupe;
}

