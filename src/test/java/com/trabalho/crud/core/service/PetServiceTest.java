package com.trabalho.crud.core.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.trabalho.crud.core.entity.Pet; // Adjusted to import Pet instead of User
import com.trabalho.crud.core.repository.PetRepository; // Adjusted to PetRepository

@ActiveProfiles("test")
@SpringBootTest
class PetServiceTest { 

  @Autowired
  private PetRepository repository; 

  @Autowired
  private PetService service; 

  @BeforeEach
void populateRepository() {
    MockitoAnnotations.openMocks(this);
    repository.save(Pet.builder()
            .id(1L) // Set the ID if you have a way to manage it
            .name("Buddy") // Changed "Bob" to "Buddy" for consistency
            .species("Dog")
            .vaccinated(true)
            .age(3)
            .owner("Caio")
            .weight(5.0)
            .gender("Male")
            .build());
    
    repository.save(Pet.builder()
            .name("Whiskers")
            .species("Cat")
            .vaccinated(true)
            .age(2)
            .owner("Bob")
            .weight(5.0)
            .gender("Female")
            .build());
    
    repository.save(Pet.builder()
            .name("Rex")
            .species("Dog")
            .vaccinated(false)
            .age(4)
            .owner("Charlie")
            .weight(25.0)
            .gender("Male")
            .build());
}
  @Test
  @DisplayName("Fetch all pets")
  void testFetchAllPets() {
    var allPets = service.findAll();

    assertEquals(3, allPets.size());
  }
}
