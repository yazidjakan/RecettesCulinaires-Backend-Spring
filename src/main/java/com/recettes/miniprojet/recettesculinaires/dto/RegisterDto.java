package com.recettes.miniprojet.recettesculinaires.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String nom;
    private int age;
    private String email;
    private String password;
}
