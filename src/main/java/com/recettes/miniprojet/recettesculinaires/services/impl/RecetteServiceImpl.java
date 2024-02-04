package com.recettes.miniprojet.recettesculinaires.services.impl;

import com.recettes.miniprojet.recettesculinaires.dto.RecetteDto;
import com.recettes.miniprojet.recettesculinaires.entities.Recette;
import com.recettes.miniprojet.recettesculinaires.repositories.RecetteDao;
import com.recettes.miniprojet.recettesculinaires.services.facade.AbstractService;
import com.recettes.miniprojet.recettesculinaires.services.facade.RecetteService;
import com.recettes.miniprojet.recettesculinaires.transformers.RecetteTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecetteServiceImpl implements RecetteService {
    @Autowired
    private RecetteDao recetteDao;
    @Autowired
    private RecetteTransformer recetteTransformer;
    @Override
    public List<RecetteDto> findAll() {
        List<Recette> recettes=recetteDao.findAll();
        return recetteTransformer.toDto(recettes);
    }

    @Override
    public RecetteDto findById(String id) {
        Recette foundeduser=recetteDao.findById(id).orElseThrow();
        return recetteTransformer.toDto(foundeduser);
    }

    @Override
    public int deleteById(String id) {
        findById(id);
        recetteDao.deleteById(id);
        return 1;
    }

    @Override
    public Optional<RecetteDto> save(RecetteDto D) {
        Recette entity=recetteTransformer.toEntity(D);
        return Optional.of(recetteTransformer.toDto(recetteDao.save(entity)));
    }

    @Override
    public Optional<List<RecetteDto>> save(List<RecetteDto> D) {
        List<RecetteDto> dtos=new ArrayList<>();
        for(RecetteDto dto: dtos){
            Recette entity=recetteTransformer.toEntity(dto);
            Recette saved=recetteDao.save(entity);
            dtos.add(recetteTransformer.toDto(saved));
        }
        return Optional.of(dtos);
    }

    @Override
    public Optional<RecetteDto> update(RecetteDto D) {
        Recette recette=recetteTransformer.toEntity(D);
        Recette recetteUpdated=recetteDao.save(recette);
        return Optional.of(recetteTransformer.toDto(recetteUpdated));
    }

    @Override
    public Optional<RecetteDto> updateById(String id, RecetteDto recetteDto) {
        recetteDto=findById(id);
        Recette recetteFounded=recetteTransformer.toEntity(recetteDto);
        recetteDao.save(recetteFounded);
        return Optional.of(recetteTransformer.toDto(recetteFounded));
    }


}
