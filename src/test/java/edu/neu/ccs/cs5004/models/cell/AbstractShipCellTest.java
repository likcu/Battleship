package edu.neu.ccs.cs5004.models.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.models.ship.Battleship;

import static org.junit.Assert.*;

public class AbstractShipCellTest {

  private Battleship battleship;
  private AbstractShipCell abstractShipCell;
  private AbstractShipCell abstractShipCell2;
  private AbstractShipCell sameRefAbstractShipCell;
  private AbstractShipCell sameStateAsAbstractShipCell;
  private AbstractShipCell diffAbstractShipCell;
  private AbstractShipCell yetAnotherAbstractShipCell;
  private AbstractShipCell nullAbstractShipCell = null;

  @Before
  public void setUp() throws Exception {

    battleship = new Battleship(4, 1);
    abstractShipCell = new SpecificShipCell(false, false, battleship);
    abstractShipCell2 = new EnemyShipCell(false, false);
    diffAbstractShipCell = new SpecificShipCell(true, false, battleship);
    sameRefAbstractShipCell = abstractShipCell;
    sameStateAsAbstractShipCell = new SpecificShipCell(false, false, battleship);
    yetAnotherAbstractShipCell = new SpecificShipCell(false, false, battleship);
  }

  @Test
  public void placeShipOnCell() {
    Assert.assertEquals(false, abstractShipCell.placeShipOnCell());
  }

  @Test
  public void getIsSunk() {
    Assert.assertEquals(false, abstractShipCell.getSunk());
  }

  @Test
  public void equals() {
    Assert.assertTrue(abstractShipCell.equals(abstractShipCell)); // reflexivity
    Assert.assertTrue(abstractShipCell.equals(sameRefAbstractShipCell)); // trivial condition both reference the same object
    Assert.assertTrue(abstractShipCell.equals(sameStateAsAbstractShipCell)); // both objects should have the same state
    Assert.assertTrue(sameStateAsAbstractShipCell.equals(abstractShipCell)); //symmetry
    Assert.assertEquals(abstractShipCell.equals(sameStateAsAbstractShipCell) && sameStateAsAbstractShipCell.equals(yetAnotherAbstractShipCell), yetAnotherAbstractShipCell.equals(abstractShipCell)); //transitivity
    Assert.assertFalse(abstractShipCell.equals(diffAbstractShipCell)); //objects have different state
    Assert.assertFalse(abstractShipCell.equals(nullAbstractShipCell)); // abstractShipCell is NOT null
    Assert.assertFalse(abstractShipCell.equals(abstractShipCell2)); // different class
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(abstractShipCell.equals(sameRefAbstractShipCell), abstractShipCell.hashCode() == sameRefAbstractShipCell.hashCode()); //same objects have the same hashCode
    Assert.assertEquals(abstractShipCell.equals(sameStateAsAbstractShipCell), abstractShipCell.hashCode() == sameStateAsAbstractShipCell.hashCode()); //equal objects have the same hashCode
  }
}