package petclinic.model;

import org.junit.jupiter.api.Test;
import petclinic.ModelTests;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest implements ModelTests {

  @Test
  void groupedAssertions() {
    // given
    Person person = new Person(1l, "Dorian", "Grey");
    // then
    assertAll("Test Props Set",
          () -> assertEquals("Dorian", person.getFirstName(), "First Name Failed"),
          () -> assertEquals("Grey", person.getLastName(), "Last Name Failed"));
  }
}