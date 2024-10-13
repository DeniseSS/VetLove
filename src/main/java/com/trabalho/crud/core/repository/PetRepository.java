package com.trabalho.crud.core.repository;

import java.util.List;
import java.util.Optional;

import com.trabalho.crud.core.entity.Pet;

public interface PetRepository {

  List<Pet> findAll();

  Optional<Pet> findById(Long id);

  Pet save(Pet pet);

  void deleteById(Long id);
}
