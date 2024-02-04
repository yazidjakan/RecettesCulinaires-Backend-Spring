package com.recettes.miniprojet.recettesculinaires.services.impl;

import com.recettes.miniprojet.recettesculinaires.dto.CategorieDto;
import com.recettes.miniprojet.recettesculinaires.entities.Categorie;
import com.recettes.miniprojet.recettesculinaires.repositories.CategorieDao;
import com.recettes.miniprojet.recettesculinaires.services.facade.CategorieService;
import com.recettes.miniprojet.recettesculinaires.transformers.CategorieTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceImpl implements CategorieService {
    @Autowired
    private CategorieDao categorieDao;
    @Autowired
    private CategorieTransformer categorieTransformer;
    @Override
    public List<CategorieDto> findAll() {
        List<Categorie> categories=categorieDao.findAll();
        return categorieTransformer.toDto(categories);
    }

    @Override
    public CategorieDto findById(String id) {
        Categorie foundeduser=categorieDao.findById(id).orElseThrow();
        return categorieTransformer.toDto(foundeduser);
    }

    @Override
    public int deleteById(String id) {
        findById(id);
        categorieDao.deleteById(id);
        return 1;
    }

    @Override
    public Optional<CategorieDto> save(CategorieDto D) {
        Categorie entity=categorieTransformer.toEntity(D);
        return Optional.of(categorieTransformer.toDto(categorieDao.save(entity)));
    }

    @Override
    public Optional<List<CategorieDto>> save(List<CategorieDto> D) {
        List<CategorieDto> dtos=new ArrayList<>();
        for(CategorieDto dto: dtos){
            Categorie entity=categorieTransformer.toEntity(dto);
            Categorie saved=categorieDao.save(entity);
            dtos.add(categorieTransformer.toDto(saved));
        }
        return Optional.of(dtos);
    }

    @Override
    public Optional<CategorieDto> update(CategorieDto D) {
        Categorie categorie=categorieTransformer.toEntity(D);
        Categorie categorieUpdated=categorieDao.save(categorie);
        return Optional.of(categorieTransformer.toDto(categorieUpdated));
    }

    @Override
    public Optional<CategorieDto> updateById(String id, CategorieDto categorieDto) {
        return Optional.empty();
    }

}
