package edu.neu.ccs.cs5004.models.ship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DestroyerTest {

  private Destroyer destroyer;
  private Destroyer destroyer2;
  private Destroyer sameRefDestroyer;
  private Destroyer sameStateAsDestroyer;
  private Destroyer diffDestroyer;
  private Destroyer yetAnotherDestroyer;
  private Destroyer nullDestroyer = null;

  @Before
  public void setUp() throws Exception {

    destroyer = new Destroyer(1, 0);
    destroyer2 = new Destroyer(1, 1);
    diffDestroyer = new Destroyer(1, 1);
    sameRefDestroyer = destroyer;
    sameStateAsDestroyer = new Destroyer(1, 0);
    yetAnotherDestroyer = new Destroyer(1, 0);
  }

  @Test
  public void hitShip() {
    Assert.assertEquals(destroyer2, destroyer.hitShip());
  }

  @Test
  public void equals() {
    Assert.assertTrue(destroyer.equals(destroyer)); // reflexivity
    Assert.assertTrue(destroyer.equals(sameRefDestroyer)); // trivial condition both reference the same object
    Assert.assertTrue(destroyer.equals(sameStateAsDestroyer)); // both objects should have the same state
    Assert.assertTrue(sameStateAsDestroyer.equals(destroyer)); //symmetry
    Assert.assertEquals(destroyer.equals(sameStateAsDestroyer) && sameStateAsDestroyer.equals(yetAnotherDestroyer), yetAnotherDestroyer.equals(destroyer)); //transitivity
    Assert.assertFalse(destroyer.equals(diffDestroyer)); //objects have different state
    Assert.assertFalse(destroyer.equals(nullDestroyer)); // destroyer is NOT null
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(destroyer.equals(sameRefDestroyer), destroyer.hashCode() == sameRefDestroyer.hashCode()); //same objects have the same hashCode
    Assert.assertEquals(destroyer.equals(sameStateAsDestroyer), destroyer.hashCode() == sameStateAsDestroyer.hashCode()); //equal objects have the same hashCode
  }
  @Test
  public void testToString() {
    Assert.assertEquals("Destroyer{" +
        "size=" + destroyer.getSize() +
        ", hitCells=" + destroyer.getHitCells() +
        '}', destroyer.toString());
  }
}