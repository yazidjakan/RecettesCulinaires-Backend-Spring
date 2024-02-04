package com.recettes.miniprojet.recettesculinaires.repositories;

import com.recettes.miniprojet.recettesculinaires.security.bean.Utilisateur;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurDao extends MongoRepository<Utilisateur,String> {
    Utilisateur findByEmail(String email);
}
