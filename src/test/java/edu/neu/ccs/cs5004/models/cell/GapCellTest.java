package edu.neu.ccs.cs5004.models.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GapCellTest {

  private GapCell gapCell;
  private GapCell gapCell2;
  private GapCell sameRefGapCell;
  private GapCell sameStateAsGapCell;
  private GapCell diffGapCell;
  private GapCell yetAnotherGapCell;
  private GapCell nullGapCell = null;


  @Before
  public void setUp() throws Exception {

    gapCell = new GapCell(true);
    gapCell2 = new GapCell(false);
    diffGapCell = new GapCell(false);
    sameRefGapCell = gapCell;
    sameStateAsGapCell = new GapCell(true);
    yetAnotherGapCell = new GapCell(true);
  }

  @Test
  public void placeShipOnCell() {
    Assert.assertEquals(false, gapCell.placeShipOnCell());
  }

  @Test
  public void attackCell() {
    Assert.assertEquals(gapCell, gapCell2.attackCell());
  }

  @Test
  public void equals() {
    Assert.assertTrue(gapCell.equals(gapCell)); // reflexivity
    Assert.assertTrue(gapCell.equals(sameRefGapCell)); // trivial condition both reference the same object
    Assert.assertTrue(gapCell.equals(sameStateAsGapCell)); // both objects should have the same state
    Assert.assertTrue(sameStateAsGapCell.equals(gapCell)); //symmetry
    Assert.assertEquals(gapCell.equals(sameStateAsGapCell) && sameStateAsGapCell.equals(yetAnotherGapCell), yetAnotherGapCell.equals(gapCell)); //transitivity
    Assert.assertFalse(gapCell.equals(diffGapCell)); //objects have different state
    Assert.assertFalse(gapCell.equals(nullGapCell)); // gapCell is NOT null
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(gapCell.equals(sameRefGapCell), gapCell.hashCode() == sameRefGapCell.hashCode()); //same objects have the same hashCode
    Assert.assertEquals(gapCell.equals(sameStateAsGapCell), gapCell.hashCode() == sameStateAsGapCell.hashCode()); //equal objects have the same hashCode
  }

  @Test
  public void testToString() {
    Assert.assertEquals("GapCell{" +
        "isHit=" + gapCell.getIsHit() +
        '}', gapCell.toString());
  }
}