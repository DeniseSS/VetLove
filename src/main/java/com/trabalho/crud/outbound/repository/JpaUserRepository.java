package com.trabalho.crud.outbound.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho.crud.core.entity.Pet;
import com.trabalho.crud.core.repository.PetRepository;

@Profile("!test")
public interface JpaUserRepository extends PetRepository, JpaRepository<Pet, Long> {
}
