package petclinic.model;

import org.junit.jupiter.api.*;
import petclinic.ModelTests;

import static org.junit.jupiter.api.Assertions.*;

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

  @RepeatedTest(value = 5, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
  @DisplayName("My Repeated Test")
  void myRepeatedTest() {
    // TODO - impl
  }

  @RepeatedTest(3)
  void myRepeatedTestWithDI(TestInfo testInfo,RepetitionInfo repetitionInfo) {
    System.out.println(testInfo.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition());
  }


}