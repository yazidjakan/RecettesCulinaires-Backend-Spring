package com.recettes.miniprojet.recettesculinaires.transformers;

import com.recettes.miniprojet.recettesculinaires.dto.RecetteDto;
import com.recettes.miniprojet.recettesculinaires.entities.Recette;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class RecetteTransformer extends AbstractTransformer<Recette, RecetteDto> {
    @Override
    public Recette toEntity(RecetteDto dto) {
        if(dto==null){
            return null;
        }else{
            Recette entity=new Recette();
            entity.setId(dto.id());
            entity.setTitre(dto.titre());
            entity.setDescription(dto.description());
            entity.setImage(dto.image());
            entity.setIngredients(dto.ingredients());
            entity.setCategorie(dto.categorie());
            entity.setFeedback(dto.feedback());
            return entity;
        }
    }

    @Override
    public List<Recette> toEntity(List<RecetteDto> dtos) {
        if (dtos == null || dtos.isEmpty()) {
            return Collections.emptyList();
        } else {
            List<Recette> entities = new ArrayList<>();
            for (RecetteDto dto : dtos) {
                entities.add(toEntity(dto));
            }
            return entities;
        }
    }

    @Override
    public RecetteDto toDto(Recette entity) {
        if(entity==null){
            return null;
        }else{
            RecetteDto dto=new RecetteDto(
                    entity.getId(),
                    entity.getTitre(),
                    entity.getDescription(),
                    entity.getImage(),
                    entity.getIngredients(),
                    entity.getCategorie(),
                    entity.getFeedback()
            );
            return dto;
        }
    }

    @Override
    public List<RecetteDto> toDto(List<Recette> entities) {
        if (entities == null || entities.isEmpty()) {
            return Collections.emptyList();
        } else {
            List<RecetteDto> dtos = new ArrayList<>();
            for (Recette entity : entities) {
                dtos.add(toDto(entity));
            }
            return dtos;
        }
    }
}
