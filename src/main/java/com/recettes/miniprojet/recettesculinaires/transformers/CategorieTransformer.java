package com.recettes.miniprojet.recettesculinaires.transformers;


import com.recettes.miniprojet.recettesculinaires.dto.CategorieDto;
import com.recettes.miniprojet.recettesculinaires.entities.Categorie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class CategorieTransformer extends AbstractTransformer<Categorie, CategorieDto> {
    @Override
    public Categorie toEntity(CategorieDto dto) {
        if(dto==null){
            return null;
        }else{
            Categorie entity=new Categorie();
            entity.setId(dto.id());
            entity.setLabel(dto.label());
            return entity;
        }
    }

    @Override
    public List<Categorie> toEntity(List<CategorieDto> dtos) {
        if (dtos == null || dtos.isEmpty()) {
            return Collections.emptyList();
        } else {
            List<Categorie> entities = new ArrayList<>();
            for (CategorieDto dto : dtos) {
                entities.add(toEntity(dto));
            }
            return entities;
        }
    }

    @Override
    public CategorieDto toDto(Categorie entity) {
        if(entity==null){
            return null;
        }else{
            CategorieDto dto=new CategorieDto(
                    entity.getId(),
                    entity.getLabel()
            );
            return dto;
        }
    }

    @Override
    public List<CategorieDto> toDto(List<Categorie> entities) {
        if (entities == null || entities.isEmpty()) {
            return Collections.emptyList();
        } else {
            List<CategorieDto> dtos = new ArrayList<>();
            for (Categorie entity : entities) {
                dtos.add(toDto(entity));
            }
            return dtos;
        }
    }
}
