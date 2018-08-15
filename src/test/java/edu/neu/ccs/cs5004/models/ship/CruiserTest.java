package edu.neu.ccs.cs5004.models.ship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CruiserTest {

  private Cruiser cruiser;
  private Cruiser cruiser2;
  private Cruiser sameRefCruiser;
  private Cruiser sameStateAsCruiser;
  private Cruiser diffCruiser;
  private Cruiser yetAnotherCruiser;
  private Cruiser nullCruiser = null;

  @Before
  public void setUp() throws Exception {

    cruiser = new Cruiser(3, 2);
    cruiser2 = new Cruiser(3, 3);
    diffCruiser = new Cruiser(3, 3);
    sameRefCruiser = cruiser;
    sameStateAsCruiser = new Cruiser(3, 2);
    yetAnotherCruiser = new Cruiser(3, 2);
  }

  @Test
  public void hitShip() {
    Assert.assertEquals(cruiser2, cruiser.hitShip());
  }

  @Test
  public void equals() {
    Assert.assertTrue(cruiser.equals(cruiser)); // reflexivity
    Assert.assertTrue(cruiser.equals(sameRefCruiser)); // trivial condition both reference the same object
    Assert.assertTrue(cruiser.equals(sameStateAsCruiser)); // both objects should have the same state
    Assert.assertTrue(sameStateAsCruiser.equals(cruiser)); //symmetry
    Assert.assertEquals(cruiser.equals(sameStateAsCruiser) && sameStateAsCruiser.equals(yetAnotherCruiser), yetAnotherCruiser.equals(cruiser)); //transitivity
    Assert.assertFalse(cruiser.equals(diffCruiser)); //objects have different state
    Assert.assertFalse(cruiser.equals(nullCruiser)); // abstractShipCell is NOT null
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(cruiser.equals(sameRefCruiser), cruiser.hashCode() == sameRefCruiser.hashCode()); //same objects have the same hashCode
    Assert.assertEquals(cruiser.equals(sameStateAsCruiser), cruiser.hashCode() == sameStateAsCruiser.hashCode()); //equal objects have the same hashCode
  }

  @Test
  public void testToString() {
    Assert.assertEquals("Cruiser{" +
        "size=" + cruiser.getSize() +
        ", hitCells=" + cruiser.getHitCells() +
        '}', cruiser.toString());
  }
}