package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


public class PointTests {
  @Test
  public void testDistance(){
    Point a = new Point(6,6);
    Point b = new Point(2,3);
    Assert.assertEquals(b.distance(a), 5.0);
  }
}
