package com.trabalho.crud.core.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.test.context.ActiveProfiles;

import com.trabalho.crud.core.entity.Pet;

@ActiveProfiles("test")
@Repository
public class PetRepositoryMemo implements PetRepository {

  private final List<Pet> Pets = new ArrayList<Pet>();

  @Override
  public List<Pet> findAll() {
    return Pets;
  }

  @Override
  public Optional<Pet> findById(Long id) {
    return Pets.stream().filter(Pet -> Pet.getId().equals(id)).findFirst();
  }

  @Override
  public Pet save(Pet Pet) {
    var id = Pets.size() + 1;
    Pet.setId((long) id);
    Pets.add(Pet);
    return Pet;
  }

  @Override
  public void deleteById(Long id) {
    Pets.removeIf(Pet -> Pet.getId() == id);
  }
}
