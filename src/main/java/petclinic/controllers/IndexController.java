package petclinic.controllers;
import org.junit.jupiter.api.*;
@Tag("controllers")
public class IndexController {
  public String index(){
    return "index";
  }

  public String oopsHandler(){
    throw new ValueNotFoundException();
  }
}
