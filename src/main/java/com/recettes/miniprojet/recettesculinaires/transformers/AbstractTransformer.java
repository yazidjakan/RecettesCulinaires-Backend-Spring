package com.recettes.miniprojet.recettesculinaires.transformers;

import java.util.List;

public abstract class AbstractTransformer<E,D> {
    public abstract E toEntity(D dto);
    public abstract List<E> toEntity(List<D> dtos);

    public abstract D toDto(E entity);
    public abstract List<D> toDto(List<E> entities);


}
