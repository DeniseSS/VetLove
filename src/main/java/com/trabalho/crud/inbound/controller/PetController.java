package com.trabalho.crud.inbound.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.crud.core.dto.PetDto;
import com.trabalho.crud.core.service.PetService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pets")
public class PetController {

  private final PetService PetService;

  @GetMapping
  public ResponseEntity<List<PetDto>> getAllUsers() {
    return ResponseEntity.ok(PetService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<PetDto> getUserById(@PathVariable Long id) {
    return ResponseEntity.ok(PetService.findById(id));
  }

  @PostMapping
  public ResponseEntity<PetDto> createUser(@RequestBody PetDto PetDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(PetService.save(PetDto));
  }

  @PutMapping("/{id}")
  public ResponseEntity<PetDto> updateUser(@PathVariable Long id, @RequestBody PetDto PetDto) {
    return ResponseEntity.ok(PetService.update(id, PetDto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    PetService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
