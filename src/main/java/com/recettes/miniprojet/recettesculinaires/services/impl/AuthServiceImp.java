package com.recettes.miniprojet.recettesculinaires.services.impl;

import com.recettes.miniprojet.recettesculinaires.dto.LoginDto;
import com.recettes.miniprojet.recettesculinaires.dto.RegisterDto;
import com.recettes.miniprojet.recettesculinaires.repositories.RoleDao;
import com.recettes.miniprojet.recettesculinaires.repositories.UtilisateurDao;
import com.recettes.miniprojet.recettesculinaires.security.bean.Role;
import com.recettes.miniprojet.recettesculinaires.security.bean.Utilisateur;
import com.recettes.miniprojet.recettesculinaires.services.facade.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthServiceImp implements AuthService {

    private AuthenticationManager authenticationManager;
    private UtilisateurDao userDao;
    private PasswordEncoder passwordEncoder;
    private JWTTokenProvider jwtTokenProvider;
    private RoleDao roleDao;


    @Override
    public String login(LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(),
                loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }


    @Override
    public String register(RegisterDto registerDto) {

        Utilisateur user = new Utilisateur();
        user.setNom(registerDto.getNom());
        user.setEmail(registerDto.getEmail());
        user.setAge(registerDto.getAge());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        Optional<Role> userRole = roleDao.findByName("ROLE_USER");
        userRole.ifPresent(roles::add);

        user.setRoles(roles);

        userDao.save(user);

        return "User register successfully";
    }



}
