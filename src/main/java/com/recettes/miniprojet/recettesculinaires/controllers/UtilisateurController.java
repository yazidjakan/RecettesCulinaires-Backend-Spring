package com.recettes.miniprojet.recettesculinaires.controllers;

import com.recettes.miniprojet.recettesculinaires.dto.UtilisateurDto;
import com.recettes.miniprojet.recettesculinaires.services.impl.UtilisateurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/utilisateurs")
@CrossOrigin(origins = "http://localhost:4200")
public class UtilisateurController {
    @Autowired
    private UtilisateurServiceImpl utilisateurService;

    @GetMapping("/")
    public ResponseEntity<List<UtilisateurDto>> findAll(){
        return ResponseEntity.ok(utilisateurService.findAll());
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<UtilisateurDto> findById(@PathVariable String id){
        return ResponseEntity.ok(utilisateurService.findById(id));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable String id){
        return ResponseEntity.ok(utilisateurService.deleteById(id));
    }
    @PostMapping("/")
    public ResponseEntity<Optional<UtilisateurDto>> save(@RequestBody UtilisateurDto utilisateurDto){
        return new ResponseEntity<>(utilisateurService.save(utilisateurDto), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Optional<UtilisateurDto>> update(@RequestBody UtilisateurDto utilisateurDto){
        return ResponseEntity.ok(utilisateurService.update(utilisateurDto));
    }
}
