package edu.neu.ccs.cs5004.models.ship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractShipTest {

  private AbstractShip abstractShip;
  private AbstractShip abstractShip2;
  private AbstractShip sameRefAbstractShip;
  private AbstractShip sameStateAsAbstractShip;
  private AbstractShip diffAbstractShip;
  private AbstractShip yetAnotherAbstractShip;
  private AbstractShip nullAbstractShip = null;

  @Before
  public void setUp() throws Exception {

    abstractShip = new Battleship(4, 2);
    abstractShip2 = new Cruiser(3, 3);
    diffAbstractShip = new Battleship(4, 3);
    sameRefAbstractShip = abstractShip;
    sameStateAsAbstractShip = new Battleship(4, 2);
    yetAnotherAbstractShip = new Battleship(4, 2);
  }

  @Test
  public void isSunk() {
    Assert.assertEquals(false, abstractShip.isSunk());
    Assert.assertEquals(true, abstractShip2.isSunk());
  }

  @Test
  public void getSize() {
    Assert.assertEquals(new Integer(4), abstractShip.getSize());
  }

  @Test
  public void getHitCells() {
    Assert.assertEquals(new Integer(2), abstractShip.getHitCells());
  }

  @Test
  public void equals() {
    Assert.assertTrue(abstractShip.equals(abstractShip)); // reflexivity
    Assert.assertTrue(abstractShip.equals(sameRefAbstractShip)); // trivial condition both reference the same object
    Assert.assertTrue(abstractShip.equals(sameStateAsAbstractShip)); // both objects should have the same state
    Assert.assertTrue(sameStateAsAbstractShip.equals(abstractShip)); //symmetry
    Assert.assertEquals(abstractShip.equals(sameStateAsAbstractShip) && sameStateAsAbstractShip.equals(yetAnotherAbstractShip), yetAnotherAbstractShip.equals(abstractShip)); //transitivity
    Assert.assertFalse(abstractShip.equals(diffAbstractShip)); //objects have different state
    Assert.assertFalse(abstractShip.equals(nullAbstractShip)); // abstractShip is NOT null
    Assert.assertFalse(abstractShip.equals(abstractShip2)); // different class
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(abstractShip.equals(sameRefAbstractShip), abstractShip.hashCode() == sameRefAbstractShip.hashCode()); //same objects have the same hashCode
    Assert.assertEquals(abstractShip.equals(sameStateAsAbstractShip), abstractShip.hashCode() == sameStateAsAbstractShip.hashCode()); //equal objects have the same hashCode
  }
}