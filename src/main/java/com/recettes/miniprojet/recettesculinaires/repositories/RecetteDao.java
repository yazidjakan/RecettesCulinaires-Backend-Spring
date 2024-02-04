package com.recettes.miniprojet.recettesculinaires.repositories;

import com.recettes.miniprojet.recettesculinaires.entities.Recette;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetteDao extends MongoRepository<Recette,String> {
}
