package com.recettes.miniprojet.recettesculinaires.security.controller;





import com.recettes.miniprojet.recettesculinaires.dto.JWTAuthResponse;
import com.recettes.miniprojet.recettesculinaires.dto.LoginDto;
import com.recettes.miniprojet.recettesculinaires.dto.RegisterDto;
import com.recettes.miniprojet.recettesculinaires.services.facade.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class AuthController {

    private AuthService authService;

    @PostMapping({"/login", "/signin"})
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto loginDto) {
        String token = authService.login(loginDto);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);

        return ResponseEntity.ok().headers(headers).body(jwtAuthResponse);
    }

    @PostMapping({"/register", "/signup"})
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
