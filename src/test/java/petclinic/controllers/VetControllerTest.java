package petclinic.controllers;

import org.assertj.core.internal.bytebuddy.matcher.ModifierMatcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import petclinic.ControllerTests;
import petclinic.fspring.ModelMapImplementation;
import petclinic.model.Vet;
import petclinic.services.SpecialtyService;
import petclinic.services.VetService;
import petclinic.services.map.SpecialityMapService;
import petclinic.services.map.VetMapService;
import petclinic.spring.Model;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VetControllerTest implements ControllerTests {

  VetService vetService;
  SpecialtyService specialtyService;
  VetController vetController;

  @BeforeEach
  void setUp() {
    specialtyService = new SpecialityMapService();
    vetService = new VetMapService(specialtyService);
    vetController = new VetController(vetService);
    Vet vet1 = new Vet(1L, "Joe", "Buck", null);
    Vet vet2 = new Vet(2L, "Jimmy", "Smith", null);

    vetService.save(vet1);
    vetService.save(vet2);

  }

  @Test
  void listVets() {
    Model model = new ModelMapImplementation();
    String view = vetController.listVets(model);
    assertThat("vets/index").isEqualTo(view);
    Set modelAttribute = (Set) ((ModelMapImplementation) model).getMap().get("vets");
    assertThat(modelAttribute.size()).isEqualTo(2);
  }
}