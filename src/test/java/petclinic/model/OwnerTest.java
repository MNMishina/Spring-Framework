package petclinic.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import petclinic.ModelTests;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OwnerTest implements ModelTests {
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

  @DisplayName("Value Source Test")
  @ParameterizedTest(name = "{displayName} - [{index}] {argumentsWithNames}")
  @ValueSource(strings = {"Spring", "Framework", "Rita"})
  void testValueSource(String val) {
    System.out.println(val);
  }

  @DisplayName("Enum Source Test")
  @ParameterizedTest(name = "{displayName} - [{index}] {argumentsWithNames}")
  @EnumSource(OwnerType.class)
  void enumTest(OwnerType ownerType) {
    System.out.println(ownerType);
  }
}
