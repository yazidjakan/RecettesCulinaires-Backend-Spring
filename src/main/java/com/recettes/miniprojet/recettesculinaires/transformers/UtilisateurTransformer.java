package com.recettes.miniprojet.recettesculinaires.transformers;

import com.recettes.miniprojet.recettesculinaires.dto.UtilisateurDto;
import com.recettes.miniprojet.recettesculinaires.security.bean.Utilisateur;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class UtilisateurTransformer extends AbstractTransformer<Utilisateur, UtilisateurDto> {
    @Override
    public Utilisateur toEntity(UtilisateurDto dto) {
        if(dto==null){
            return null;
        }else{
            Utilisateur entity=new Utilisateur();
            entity.setId(dto.id());
            entity.setNom(dto.nom());
            entity.setAge(dto.age());
            entity.setEmail(dto.email());
            entity.setPassword(dto.password());
            return entity;
        }
    }

    @Override
    public List<Utilisateur> toEntity(List<UtilisateurDto> dtos) {
        if (dtos == null || dtos.isEmpty()) {
            return Collections.emptyList();
        } else {
            List<Utilisateur> entities = new ArrayList<>();
            for (UtilisateurDto dto : dtos) {
                entities.add(toEntity(dto));
            }
            return entities;
        }
    }

    @Override
    public UtilisateurDto toDto(Utilisateur entity) {
        if(entity==null) {
            return null;
        }else{
            UtilisateurDto dto=new UtilisateurDto(
                    entity.getId(),
                    entity.getNom(),
                    entity.getAge(),
                    entity.getEmail(),
                    entity.getPassword()
            );
            return dto;
        }
    }

    @Override
    public List<UtilisateurDto> toDto(List<Utilisateur> entities) {
        if (entities == null || entities.isEmpty()) {
            return Collections.emptyList();
        } else {
            List<UtilisateurDto> dtos = new ArrayList<>();
            for (Utilisateur entity : entities) {
                dtos.add(toDto(entity));
            }
            return dtos;
        }
    }
}
