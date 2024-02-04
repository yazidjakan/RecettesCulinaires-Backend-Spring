package com.recettes.miniprojet.recettesculinaires.repositories;

import com.recettes.miniprojet.recettesculinaires.security.bean.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleDao extends MongoRepository<Role,String> {

    Optional<Role> findByName(String name);

}
