package com.recettes.miniprojet.recettesculinaires.controllers;

import com.recettes.miniprojet.recettesculinaires.dto.RecetteDto;
import com.recettes.miniprojet.recettesculinaires.services.impl.RecetteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/recettes")
public class RecetteController {
    @Autowired
    private RecetteServiceImpl recetteService;

    @GetMapping("/")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<RecetteDto>> findAll(){
        return ResponseEntity.ok(recetteService.findAll());
    }
    @GetMapping("/id/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<RecetteDto> findById(@PathVariable String id){
        return ResponseEntity.ok(recetteService.findById(id));
    }

    @DeleteMapping("/id/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<Integer> deleteById(@PathVariable String id){
        return ResponseEntity.ok(recetteService.deleteById(id));
    }
    @PostMapping("/")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<Optional<RecetteDto>> save(@RequestBody RecetteDto recetteDto){
        return new ResponseEntity<>(recetteService.save(recetteDto), HttpStatus.CREATED);
    }
    @PutMapping("/")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<Optional<RecetteDto>> update(@RequestBody RecetteDto recetteDto){
        return ResponseEntity.ok(recetteService.update(recetteDto));
    }
    @PutMapping("/id/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<Optional<RecetteDto>> updateById(@PathVariable String id, @RequestBody RecetteDto recetteDto){
            return ResponseEntity.ok(recetteService.updateById(id, recetteDto));
    }
}
