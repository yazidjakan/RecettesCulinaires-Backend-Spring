package com.recettes.miniprojet.recettesculinaires.services.facade;

import com.recettes.miniprojet.recettesculinaires.dto.UtilisateurDto;


public interface UtilisateurService extends AbstractService<UtilisateurDto,String>{
    UtilisateurDto findByEmail(String email);

}
