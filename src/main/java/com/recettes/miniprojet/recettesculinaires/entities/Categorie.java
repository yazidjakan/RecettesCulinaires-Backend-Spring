package com.recettes.miniprojet.recettesculinaires.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="categorie")
public class Categorie {
    @Id
    private String id;
    private String label;
}
