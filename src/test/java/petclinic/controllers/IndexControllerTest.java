package petclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;
import petclinic.ControllerTests;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest implements ControllerTests {

  IndexController controller;

  @BeforeEach
  void setUp() {
    controller = new IndexController();
  }

  @Test
  @DisplayName("Test Proper name is returned for index page")
  void index() {
    assertEquals("index", controller.index(), "Wrong View Returned");
    assertEquals("index", controller.index(), () -> "Another Message " +
          "Make me if you need to");
    assertThat(controller.index()).isEqualTo("index");
  }

  @Test
  @DisplayName("Test exception")
  void oopsHandler() {
    assertThrows(ValueNotFoundException.class, () -> {
      controller.oopsHandler();
    });
  }

  @Disabled("Demo of timeout")
  @Test
  void testTimeOut() {
    assertTimeout(Duration.ofMillis(100), () -> {
      Thread.sleep(5000);
      System.out.println("Got here !");
    });
  }

  @Disabled("Demo of timeout")
  @Test
  void testTimeOutPrempt() {
    assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
      Thread.sleep(5000);
      System.out.println("Got here 15641646461683546");
    });
  }

  @Test
  void testAssumptionIsNotTrue() {
    assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
  }

  @Test
  void testAssumptionIsTrue() {
    assumeTrue("GURU".equalsIgnoreCase("GURU"));
  }

  @DisabledOnOs(OS.MAC)
  @Test
  void testMeOnMacOS() {

  }

  @EnabledOnOs(OS.WINDOWS)
  @Test
  void testMeOnWindows() {

  }

  @DisabledOnJre(JRE.JAVA_11)
  @Test
  void testMeOnJava11() {

  }

  @EnabledOnJre(JRE.JAVA_17)
  @Test
  void testMeOnJava17() {

  }


}