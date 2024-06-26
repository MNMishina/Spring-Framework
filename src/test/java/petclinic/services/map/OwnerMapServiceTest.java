package petclinic.services.map;

import org.junit.jupiter.api.*;
import petclinic.model.Owner;
import petclinic.model.PetType;
import petclinic.services.PetService;
import petclinic.services.PetTypeService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Owner Map Service Test - ")
class OwnerMapServiceTest {
  OwnerMapService ownerMapService;
  PetTypeService petTypeService;
  PetService petService;

  @BeforeEach
  void setUp() {
    petTypeService = new PetTypeMapService();
    petService = new PetMapService();
    ownerMapService = new OwnerMapService(petTypeService, petService);

    System.out.println("First Before Each");
  }
  @DisplayName("Verify Zero Owners")
  @Test
  void ownersAreZero() {
    int ownerCount = ownerMapService.findAll().size();
    assertThat(ownerCount).isZero();
  }

  @DisplayName("Pet Type - ")
  @Nested
  class TestCreatePetTypes {
    @BeforeEach
    void setUp() {
      PetType petType = new PetType(1L, "Dog");
      PetType petType2 = new PetType(2L, "Cat");
      petTypeService.save(petType);
      petTypeService.save(petType2);

      System.out.println("Nested Before Each");
    }

    @Test
    void testPetCount() {
      int petTypeCount = petTypeService.findAll().size();
      assertThat(petTypeCount).isNotZero().isEqualTo(2);
    }

    @DisplayName("Save Owners Tests - ")
    @Nested
    class SaveOwnersTests {
      @BeforeEach
      void setUp() {
        ownerMapService.save(new Owner(1L, "Before", "Each"));

        System.out.println("Saved Owners Before Each");
      }

      @Test
      void saveOwner() {
        Owner owner = new Owner(2L, "Joe", "Buck");
        Owner savedOwner = ownerMapService.save(owner);
        assertThat(savedOwner).isNotNull();
      }

      @DisplayName("Find Owners Tests - ")
      @Nested
      class FindOwnersTests {

        @DisplayName("Find Owner")
        @Test
        void findOwner() {
          Owner foundOwner = ownerMapService.findById(1L);
          assertThat(foundOwner).isNotNull();
        }

        @DisplayName("Owner Not Found")
        @Test
        void ownerNotFound() {
          Owner foundOwner = ownerMapService.findById(2L);
          assertThat(foundOwner).isNull();
        }
      }
    }
  }

  @DisplayName("Verify Still Zero Owners")
  @Test
  void ownersAreStillZero() {
    int ownerCount = ownerMapService.findAll().size();
    assertThat(ownerCount).isZero();
  }

}