package com.recettes.miniprojet.recettesculinaires.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recettes.miniprojet.recettesculinaires.entities.Categorie;

import java.util.List;

public record RecetteDto(
        @JsonProperty("id") String id,
        @JsonProperty("titre") String titre,
        @JsonProperty("description") String description,
        @JsonProperty("image") String image,
        @JsonProperty("ingredients") String ingredients,
        @JsonProperty("categorie") Categorie categorie,
        @JsonProperty("feedback") String feedback
) {}
