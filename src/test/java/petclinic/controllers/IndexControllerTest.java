package petclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

  IndexController controller;

  @BeforeEach
  void setUp() {
    controller = new IndexController();
  }

  @Test
  void index() {
    assertEquals("index", controller.index(), "Wrong View Returned");
    assertEquals("index", controller.index(), () -> "Another Message " +
          "Make me if you need to");
  }

  @Test
  void oupsHandler() {
    assertTrue("notimplemented".equals(controller.oupsHandler()), () -> "This is some expensive" +
          "Message to build" + "for the test");
  }
}