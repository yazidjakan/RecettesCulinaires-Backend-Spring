package com.recettes.miniprojet.recettesculinaires.services.facade;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface AbstractService<D,I> {
    List<D> findAll();

    D findById(I id);

    int deleteById(I id);

    Optional<D> save(D D);

    Optional<List<D>> save(List<D> D);

    Optional<D> update(D D);

    Optional<D> updateById(I id, D D);

}
