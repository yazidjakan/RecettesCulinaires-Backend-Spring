package com.recettes.miniprojet.recettesculinaires.controllers;

import com.recettes.miniprojet.recettesculinaires.dto.CategorieDto;
import com.recettes.miniprojet.recettesculinaires.services.impl.CategorieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/categories")
@CrossOrigin(origins = "http://localhost:4200")
public class CategorieController {
    @Autowired
    private CategorieServiceImpl categorieService;

    @GetMapping("/")
    public ResponseEntity<List<CategorieDto>> findAll(){
        return ResponseEntity.ok(categorieService.findAll());
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<CategorieDto> findById(@PathVariable String id){
        return ResponseEntity.ok(categorieService.findById(id));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable String id){
        return ResponseEntity.ok(categorieService.deleteById(id));
    }
    @PostMapping("/")
    public ResponseEntity<Optional<CategorieDto>> save(@RequestBody CategorieDto categorieDto){
        return new ResponseEntity<>(categorieService.save(categorieDto), HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity<Optional<CategorieDto>> update(@RequestBody CategorieDto categorieDto){
        return ResponseEntity.ok(categorieService.update(categorieDto));
    }
}
