package com.recettes.miniprojet.recettesculinaires.security.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="utilisateur")
public class Utilisateur {
    @Id
    private String id;
    private String nom;
    private int age;
    private String email;
    private String password;
    private Set<Role> roles = new HashSet<>();

}
