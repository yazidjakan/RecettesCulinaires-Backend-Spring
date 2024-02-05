package com.recettes.miniprojet.recettesculinaires.services.impl;

import com.recettes.miniprojet.recettesculinaires.dto.UtilisateurDto;
import com.recettes.miniprojet.recettesculinaires.repositories.RoleDao;
import com.recettes.miniprojet.recettesculinaires.security.bean.Role;
import com.recettes.miniprojet.recettesculinaires.security.bean.Utilisateur;
import com.recettes.miniprojet.recettesculinaires.security.dto.RoleDto;
import com.recettes.miniprojet.recettesculinaires.services.facade.RoleService;
import com.recettes.miniprojet.recettesculinaires.transformers.RoleTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RoleTransformer roleTransformer;

    @Override
    public List<RoleDto> findAll() {
        return roleTransformer.toDto(roleDao.findAll());
    }

    @Override
    public RoleDto findById(String id) {
        Role foundedrole=roleDao.findById(id).orElseThrow();
        return roleTransformer.toDto(foundedrole);
    }

    @Override
    public int deleteById(String id) {
        findById(id);
        roleDao.deleteById(id);
        return 1;
    }

    @Override
    public Optional<RoleDto> save(RoleDto D) {
        Role entity=roleTransformer.toEntity(D);
        return Optional.of(roleTransformer.toDto(roleDao.save(entity)));
    }

    @Override
    public Optional<List<RoleDto>> save(List<RoleDto> D) {
        List<RoleDto> dtos=new ArrayList<>();
        for(RoleDto dto: dtos){
            Role entity=roleTransformer.toEntity(dto);
            Role saved=roleDao.save(entity);
            dtos.add(roleTransformer.toDto(saved));
        }
        return Optional.of(dtos);
    }

    @Override
    public Optional<RoleDto> update(RoleDto D) {
        Role role=roleTransformer.toEntity(D);
        Role roleUpdated=roleDao.save(role);
        return Optional.of(roleTransformer.toDto(roleUpdated));
    }

    @Override
    public Optional<RoleDto> updateById(String id, RoleDto D) {
        return Optional.empty();
    }
}
