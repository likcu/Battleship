package edu.neu.ccs.cs5004.models.ship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubmarineTest {

  private Submarine submarine;
  private Submarine submarine2;
  private Submarine sameRefSubmarine;
  private Submarine sameStateAsSubmarine;
  private Submarine diffSubmarine;
  private Submarine yetAnotherSubmarine;
  private Submarine nullSubmarine = null;

  @Before
  public void setUp() throws Exception {

    submarine = new Submarine(2, 1);
    submarine2 = new Submarine(2, 2);
    diffSubmarine = new Submarine(2, 2);
    sameRefSubmarine = submarine;
    sameStateAsSubmarine = new Submarine(2, 1);
    yetAnotherSubmarine = new Submarine(2, 1);
  }

  @Test
  public void hitShip() {

    Assert.assertEquals(submarine2, submarine.hitShip());
  }

  @Test
  public void equals() {
    Assert.assertTrue(submarine.equals(submarine)); // reflexivity
    Assert.assertTrue(submarine.equals(sameRefSubmarine)); // trivial condition both reference the same object
    Assert.assertTrue(submarine.equals(sameStateAsSubmarine)); // both objects should have the same state
    Assert.assertTrue(sameStateAsSubmarine.equals(submarine)); //symmetry
    Assert.assertEquals(submarine.equals(sameStateAsSubmarine) && sameStateAsSubmarine.equals(yetAnotherSubmarine), yetAnotherSubmarine.equals(submarine)); //transitivity
    Assert.assertFalse(submarine.equals(diffSubmarine)); //objects have different state
    Assert.assertFalse(submarine.equals(nullSubmarine)); // abstractShipCell is NOT null
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(submarine.equals(sameRefSubmarine), submarine.hashCode() == sameRefSubmarine.hashCode()); //same objects have the same hashCode
    Assert.assertEquals(submarine.equals(sameStateAsSubmarine), submarine.hashCode() == sameStateAsSubmarine.hashCode()); //equal objects have the same hashCode
  }

  @Test
  public void testToString() {
    Assert.assertEquals("Submarine{" +
        "size=" + submarine.getSize() +
        ", hitCells=" + submarine.getHitCells() +
        '}', submarine.toString());

  }
}