package edu.neu.ccs.cs5004.models.attackresult;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SunkTest {

  private Sunk sunk;
  private Sunk sameRefSunk;
  private Sunk sameStateAsSunk;
  private Sunk yetAnotherSunk;
  private Sunk nullSunk = null;

  @Before
  public void setUp() throws Exception {
    sunk = new Sunk();
    sameRefSunk = new Sunk();
    sameStateAsSunk = new Sunk();
    yetAnotherSunk = new Sunk();
  }

  @Test
  public void equals() {
    Assert.assertTrue(sunk.equals(sunk)); // reflexivity
    Assert.assertTrue(sunk.equals(sameRefSunk)); // trivial condition both reference the same object
    Assert.assertTrue(sunk.equals(sameStateAsSunk)); // both objects should have the same state
    Assert.assertTrue(sunk.equals(sunk)); //symmetry
    Assert.assertEquals(sunk.equals(sameStateAsSunk) && sameStateAsSunk.equals(yetAnotherSunk), yetAnotherSunk.equals(sunk)); //transitivity
    Assert.assertFalse(sunk.equals(nullSunk)); // sunk is NOT null
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(sunk.equals(sameRefSunk), sunk.hashCode() == sameRefSunk.hashCode()); //same objects have the same hashCode
    Assert.assertEquals(sunk.equals(sameStateAsSunk), sunk.hashCode() == sameStateAsSunk.hashCode()); //equal objects have the same hashCode
  }

  @Test
  public void testToString() {
    Assert.assertEquals("Sunk{}", sunk.toString());
  }
}