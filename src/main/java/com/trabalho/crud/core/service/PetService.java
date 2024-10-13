package com.trabalho.crud.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trabalho.crud.core.dto.PetDto;
import com.trabalho.crud.core.entity.BusinessException;
import com.trabalho.crud.core.mapper.PetMapper;
import com.trabalho.crud.core.repository.PetRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PetService {

  private final PetRepository repository;

  private final PetMapper mapper;

  public List<PetDto> findAll() {
    return repository.findAll().stream().map(user -> mapper.toDto(user)).toList();
  }

  public PetDto findById(Long id) {
    return repository.findById(id).map(user -> mapper.toDto(user))
        .orElseThrow(() -> BusinessException.notFoundException("Usuário não encontrado"));
  }

  public PetDto save(PetDto PetDto) {
    var user = mapper.toEntity(PetDto);
    return mapper.toDto(repository.save(user));
  }

  public PetDto update(Long id, PetDto PetDto) {
    var existingUser = this.findById(id);
    PetDto.setId(existingUser.getId());
    var user = mapper.toEntity(PetDto);
    return mapper.toDto(repository.save(user));
  }

  public void deleteById(Long id) {
    this.findById(id);
    repository.deleteById(id);
  }

}
