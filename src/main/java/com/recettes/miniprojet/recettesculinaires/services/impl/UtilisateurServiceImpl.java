package com.recettes.miniprojet.recettesculinaires.services.impl;

import com.recettes.miniprojet.recettesculinaires.dto.UtilisateurDto;
import com.recettes.miniprojet.recettesculinaires.security.bean.Utilisateur;
import com.recettes.miniprojet.recettesculinaires.repositories.UtilisateurDao;
import com.recettes.miniprojet.recettesculinaires.services.facade.UtilisateurService;
import com.recettes.miniprojet.recettesculinaires.transformers.UtilisateurTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    @Autowired
    private UtilisateurDao utilisateurDao;
    @Autowired
    private UtilisateurTransformer utilisateurTransformer;
    @Override
    public List<UtilisateurDto> findAll() {
        List<Utilisateur> utilisateurs=utilisateurDao.findAll();
        return utilisateurTransformer.toDto(utilisateurs);
    }

    @Override
    public UtilisateurDto findById(String id) {
        Utilisateur foundeduser=utilisateurDao.findById(id).orElseThrow();
        return utilisateurTransformer.toDto(foundeduser);
    }

    @Override
    public int deleteById(String id) {
        findById(id);
        utilisateurDao.deleteById(id);
        return 1;

    }

    @Override
    public Optional<UtilisateurDto> save(UtilisateurDto D) {
        Utilisateur entity=utilisateurTransformer.toEntity(D);
        return Optional.of(utilisateurTransformer.toDto(utilisateurDao.save(entity)));
    }

    @Override
    public Optional<List<UtilisateurDto>> save(List<UtilisateurDto> D) {
        List<UtilisateurDto> dtos=new ArrayList<>();
        for(UtilisateurDto dto: dtos){
            Utilisateur entity=utilisateurTransformer.toEntity(dto);
            Utilisateur saved=utilisateurDao.save(entity);
            dtos.add(utilisateurTransformer.toDto(saved));
        }
        return Optional.of(dtos);
    }


    @Override
    public Optional<UtilisateurDto> update(UtilisateurDto D) {
        Utilisateur utilisateur=utilisateurTransformer.toEntity(D);
        Utilisateur userUpdated=utilisateurDao.save(utilisateur);
        return Optional.of(utilisateurTransformer.toDto(userUpdated));

    }

    @Override
    public Optional<UtilisateurDto> updateById(String id, UtilisateurDto utilisateurDto) {
        return Optional.empty();
    }


    @Override
    public UtilisateurDto findByEmail(String email) {
        Utilisateur utilisateur=utilisateurDao.findByEmail(email);
        return utilisateurTransformer.toDto(utilisateur);
    }
}
