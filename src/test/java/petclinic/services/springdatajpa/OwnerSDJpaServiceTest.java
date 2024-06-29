package petclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import petclinic.model.Owner;

@Disabled(value = "Disabled until we learn Mocking")
class OwnerSDJpaServiceTest {
  OwnerSDJpaService service;

  @BeforeEach
  void setUp() {
    service = new OwnerSDJpaService(null, null, null);
  }

  @Disabled
  @Test
  void findByLastName() {
    Owner foundOwner = service.findByLastName("Dawson");
  }

  @Test
  void findAllByLastNameLike() {
  }

  @Test
  void findAll() {
  }

  @Test
  void findById() {
  }

  @Test
  void save() {
  }

  @Test
  void delete() {
  }

  @Test
  void deleteById() {
  }
}