package ru.stqa.pft.rest;


import org.testng.annotations.Test;

import java.io.IOException;

public class ExampleTests extends TestBase {
  @Test
  public void exampleTest() throws IOException {
    skipIfNotFixed(8);
  }
}
