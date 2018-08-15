package edu.neu.ccs.cs5004.models.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.models.attackresult.Hit;
import edu.neu.ccs.cs5004.models.attackresult.Miss;
import edu.neu.ccs.cs5004.models.attackresult.Sunk;
import edu.neu.ccs.cs5004.models.ship.Battleship;

public class SpecificShipCellTest {

  private Battleship battleship;
  private Battleship battleship2;
  private Battleship battleship3;
  private SpecificShipCell specificShipCell;
  private SpecificShipCell specificShipCell2;
  private SpecificShipCell specificShipCell3;
  private SpecificShipCell specificShipCell4;
  private SpecificShipCell specificShipCell5;
  private SpecificShipCell sameRefSpecificShipCell;
  private SpecificShipCell sameStateAsSpecificShipCell;
  private SpecificShipCell diffSpecificShipCell;
  private SpecificShipCell yetAnotherSpecificShipCell;
  private SpecificShipCell nullSpecificShipCell = null;

  @Before
  public void setUp() throws Exception {

    battleship = new Battleship(4, 4);
    battleship2 = new Battleship(4, 0);
    battleship3 = new Battleship(4, 1);
    specificShipCell = new SpecificShipCell(true, true, battleship);
    specificShipCell2 = new SpecificShipCell(true, true, battleship);
    specificShipCell3 = new SpecificShipCell(true, false, battleship);
    specificShipCell4 = new SpecificShipCell(false, false, battleship2);
    specificShipCell5 = new SpecificShipCell(true, false, battleship3);
    diffSpecificShipCell = new SpecificShipCell(true, false, battleship);
    sameRefSpecificShipCell = specificShipCell;
    sameStateAsSpecificShipCell = new SpecificShipCell(true, true, battleship);
    yetAnotherSpecificShipCell = new SpecificShipCell(true, true, battleship);
  }

  @Test
  public void getShip() {
    Assert.assertEquals(battleship, specificShipCell.getShip());
  }

  @Test
  public void attackCell() {
    Assert.assertEquals(specificShipCell5, specificShipCell4.attackCell());
  }

  @Test
  public void markAsSunk() {
    Assert.assertEquals(specificShipCell, specificShipCell2.markAsSunk());
    Assert.assertEquals(specificShipCell4, specificShipCell4.markAsSunk());
  }

  @Test
  public void getAttachResult() {
    Assert.assertEquals(new Hit(), specificShipCell5.getAttackResult());
    Assert.assertEquals(new Sunk(), specificShipCell.getAttackResult());
    Assert.assertEquals(new Miss(), specificShipCell4.getAttackResult());
  }

  @Test
  public void equals() {
    Assert.assertTrue(specificShipCell.equals(specificShipCell)); // reflexivity
    Assert.assertTrue(specificShipCell.equals(sameRefSpecificShipCell)); // trivial condition both reference the same object
    Assert.assertTrue(specificShipCell.equals(sameStateAsSpecificShipCell)); // both objects should have the same state
    Assert.assertTrue(sameStateAsSpecificShipCell.equals(specificShipCell)); //symmetry
    Assert.assertEquals(specificShipCell.equals(sameStateAsSpecificShipCell) && sameStateAsSpecificShipCell.equals(yetAnotherSpecificShipCell), yetAnotherSpecificShipCell.equals(specificShipCell)); //transitivity
    Assert.assertFalse(specificShipCell.equals(diffSpecificShipCell)); //objects have different state
    Assert.assertFalse(specificShipCell.equals(nullSpecificShipCell)); // specificShipCell is NOT null
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(specificShipCell.equals(sameRefSpecificShipCell), specificShipCell.hashCode() == sameRefSpecificShipCell.hashCode()); //same objects have the same hashCode
    Assert.assertEquals(specificShipCell.equals(sameStateAsSpecificShipCell), specificShipCell.hashCode() == sameStateAsSpecificShipCell.hashCode()); //equal objects have the same hashCode
  }

  @Test
  public void testToString() {
    Assert.assertEquals("SpecificShipCell{" +
        "ship=" + specificShipCell.getShip() +
        ", isSunk=" + specificShipCell.getSunk() +
        ", isHit=" + specificShipCell.getIsHit() +
        '}', specificShipCell.toString());
  }
}