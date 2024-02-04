package com.recettes.miniprojet.recettesculinaires.dto;

import com.recettes.miniprojet.recettesculinaires.entities.Recette;

import java.util.List;

public record UtilisateurDto(
        String id,
        String nom,
        int age,
        String email,
        String password

) {
}
