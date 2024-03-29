package com.recettes.miniprojet.recettesculinaires.services.facade;

import com.recettes.miniprojet.recettesculinaires.security.dto.LoginDto;
import com.recettes.miniprojet.recettesculinaires.security.dto.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
