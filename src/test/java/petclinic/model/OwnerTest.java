package petclinic.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("model")
public class OwnerTest {
  @Test
  void dependentAssertions() {
    Owner owner = new Owner(1l, "Joe", "Dawson");
    owner.setCity("Key West");
    owner.setTelephone("1231231234");

    assertAll("Properties Test",
          () -> assertAll("Person Properties",
                () -> assertEquals("Joe", owner.getFirstName(), "First Name didn't Match"),
                () -> assertEquals("Dawson", owner.getLastName())),
          () -> assertAll("Owner Properties",
                () -> assertEquals("Key West", owner.getCity(), "City didn't Match"),
                () -> assertEquals("1231231234", owner.getTelephone())
          ));
    //assertThat(owner.getCity(), is("Key West"));
  }
}
