package com.fisa.bddgestion.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "materiels")
public class Materiel {
    @Id
    private String id;
    private String numeroSerie;
    private String marque;
    private String modele;
    private TypeMateriel type;
    private Double prix;
    private String numeroGroupe;
}

