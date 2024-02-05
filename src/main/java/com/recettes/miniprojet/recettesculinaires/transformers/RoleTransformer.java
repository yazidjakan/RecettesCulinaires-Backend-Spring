package com.recettes.miniprojet.recettesculinaires.transformers;

import com.recettes.miniprojet.recettesculinaires.dto.UtilisateurDto;
import com.recettes.miniprojet.recettesculinaires.security.bean.Role;
import com.recettes.miniprojet.recettesculinaires.security.bean.Utilisateur;
import com.recettes.miniprojet.recettesculinaires.security.dto.RoleDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class RoleTransformer extends AbstractTransformer<Role, RoleDto> {
    @Override
    public Role toEntity(RoleDto dto) {
        if(dto==null){
            return null;
        }else{
            Role entity=new Role();
            entity.setId(dto.id());
            entity.setName(dto.name());
            return entity;
        }
    }

    @Override
    public List<Role> toEntity(List<RoleDto> dtos) {
        if (dtos == null || dtos.isEmpty()) {
            return Collections.emptyList();
        } else {
            List<Role> entities = new ArrayList<>();
            for (RoleDto dto : dtos) {
                entities.add(toEntity(dto));
            }
            return entities;
        }
    }

    @Override
    public RoleDto toDto(Role entity) {
        if(entity==null) {
            return null;
        }else{
            RoleDto dto=new RoleDto(
                    entity.getId(),
                    entity.getName()
            );
            return dto;
        }
    }

    @Override
    public List<RoleDto> toDto(List<Role> entities) {
        if (entities == null || entities.isEmpty()) {
            return Collections.emptyList();
        } else {
            List<RoleDto> dtos = new ArrayList<>();
            for (Role entity : entities) {
                dtos.add(toDto(entity));
            }
            return dtos;
        }
    }
}
