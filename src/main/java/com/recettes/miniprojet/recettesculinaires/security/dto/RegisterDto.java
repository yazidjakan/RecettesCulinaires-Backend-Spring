package com.recettes.miniprojet.recettesculinaires.security.dto;

import com.recettes.miniprojet.recettesculinaires.security.bean.Role;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class RegisterDto {
    private String nom;
    private int age;
    private String email;
    private String password;
}
