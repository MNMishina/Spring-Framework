package petclinic.controllers;

import petclinic.services.VetService;
import petclinic.spring.Model;

public class VetController {
  private final VetService vetService;

  public VetController(VetService vetService) {
    this.vetService = vetService;
  }

  public String listVets(Model model){

    model.addAttribute("vets", vetService.findAll());

    return "vets/index";
  }
}
