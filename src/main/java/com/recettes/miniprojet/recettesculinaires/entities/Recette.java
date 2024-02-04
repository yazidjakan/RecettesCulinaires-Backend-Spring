package com.recettes.miniprojet.recettesculinaires.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "recette")
public class Recette {
    @Id
    private String id;
    private String titre;
    private String description;
    private String image;
    private String ingredients;
    private Categorie categorie;
    private String feedback;
}
