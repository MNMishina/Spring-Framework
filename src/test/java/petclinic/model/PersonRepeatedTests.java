package petclinic.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;
import petclinic.ModelRepeatedTests;

public class PersonRepeatedTests implements ModelRepeatedTests {
  @RepeatedTest(value = 5, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
  @DisplayName("My Repeated Test")
  void myRepeatedTest() {
    // impl
  }

  @RepeatedTest(3)
  void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
    System.out.println(testInfo.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition());
  }

  @RepeatedTest(value = 5, name = "{displayName} : {currentRepetition} | {totalRepetitions}")
  @DisplayName("My Assignment Repeated Test")
  void assignmentRepeated() {
    // impl
  }
}
