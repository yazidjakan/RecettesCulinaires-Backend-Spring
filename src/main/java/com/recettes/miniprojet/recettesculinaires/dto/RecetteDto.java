package com.recettes.miniprojet.recettesculinaires.dto;

import com.recettes.miniprojet.recettesculinaires.entities.Categorie;

import java.util.List;

public record RecetteDto(
        String id,
        String titre,
        String description,
        String image,
        String ingredients,
        Categorie categorie,
        String feedback
) {
}
