package com.recettes.miniprojet.recettesculinaires.security.controller;


import com.recettes.miniprojet.recettesculinaires.security.dto.RoleDto;
import com.recettes.miniprojet.recettesculinaires.services.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/roles")
@CrossOrigin(origins = "http://localhost:4200")
public class RoleController {
    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping("/")
    public ResponseEntity<List<RoleDto>> findAll(){
        return ResponseEntity.ok(roleService.findAll());
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<RoleDto> findById(@PathVariable String id){
        return ResponseEntity.ok(roleService.findById(id));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable String id){
        return ResponseEntity.ok(roleService.deleteById(id));
    }
    @PostMapping("/")
    public ResponseEntity<Optional<RoleDto>> save(@RequestBody RoleDto roleDto){
        return new ResponseEntity<>(roleService.save(roleDto), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Optional<RoleDto>> update(@RequestBody RoleDto roleDto){
        return ResponseEntity.ok(roleService.update(roleDto));
    }
}
