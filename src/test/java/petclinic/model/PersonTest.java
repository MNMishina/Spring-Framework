package petclinic.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("model")
class PersonTest {

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