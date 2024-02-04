package com.recettes.miniprojet.recettesculinaires.repositories;

import com.recettes.miniprojet.recettesculinaires.entities.Categorie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieDao extends MongoRepository<Categorie,String> {
}
