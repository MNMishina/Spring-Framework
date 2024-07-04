package petclinic.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import petclinic.CustomArgumentsProvider;
import petclinic.ModelTests;

import java.util.stream.Stream;

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

  @DisplayName("CSV Input Test")
  @ParameterizedTest(name = "{displayName} - [{index}] {argumentsWithNames}")
  @CsvSource({
        "FL, 1, 1",
        "OH, 2, 2",
        "MI, 3, 1"
  })
  void csvInputTest(String stateName, int val1, int val2) {
    System.out.println(stateName + " = " + val1 + " : " + val2);
  }

  @DisplayName("CSV From File Test")
  @ParameterizedTest(name = "{displayName} - [{index}] {argumentsWithNames}")
  @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    // numLinesToSkip is skipping the Header in the file
  void csvFromFileTest(String stateName, int val1, int val2) {
    System.out.println(stateName + " = " + val1 + " : " + val2);
  }

  @DisplayName("Method Provider Test")
  @ParameterizedTest(name = "{displayName} - [{index}] {argumentsWithNames}")
  @MethodSource("getArgs")
  void fromMethodTest(String stateName, int val1, int val2) {
    System.out.println(stateName + " = " + val1 + " : " + val2);
  }

  static Stream<Arguments> getArgs() {
    return Stream.of(
          Arguments.of("FL", 5, 1),
          Arguments.of("OH", 2, 8),
          Arguments.of("MI", 3, 5));
  }

  @DisplayName("Custom Provider Test")
  @ParameterizedTest(name = "{displayName} - [{index}] {argumentsWithNames}")
  @ArgumentsSource(CustomArgumentsProvider.class)
  void customProviderTest(String stateName, int val1, int val2) {
    System.out.println(stateName + " = " + val1 + " : " + val2);
  }
}
