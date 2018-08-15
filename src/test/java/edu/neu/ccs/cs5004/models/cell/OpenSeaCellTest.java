package edu.neu.ccs.cs5004.models.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OpenSeaCellTest {

  private OpenSeaCell openSeaCell;
  private OpenSeaCell openSeaCell2;
  private OpenSeaCell sameRefOpenSeaCell;
  private OpenSeaCell sameStateAsOpenSeaCell;
  private OpenSeaCell diffOpenSeaCell;
  private OpenSeaCell yetAnotherOpenSeaCell;
  private OpenSeaCell nullOpenSeaCell = null;


  @Before
  public void setUp() throws Exception {

    openSeaCell = new OpenSeaCell(true);
    openSeaCell2 = new OpenSeaCell(false);
    diffOpenSeaCell = new OpenSeaCell(false);
    sameRefOpenSeaCell = openSeaCell;
    sameStateAsOpenSeaCell = new OpenSeaCell(true);
    yetAnotherOpenSeaCell = new OpenSeaCell(false);
  }

  @Test
  public void placeShipOnCell() {
    Assert.assertEquals(true, openSeaCell.placeShipOnCell());
  }

  @Test
  public void attackCell() {
    Assert.assertEquals(openSeaCell, openSeaCell2.attackCell());
  }

  @Test
  public void equals() {

    Assert.assertTrue(openSeaCell.equals(openSeaCell)); // reflexivity
    Assert.assertTrue(openSeaCell.equals(sameRefOpenSeaCell)); // trivial condition both reference the same object
    Assert.assertTrue(openSeaCell.equals(sameStateAsOpenSeaCell)); // both objects should have the same state
    Assert.assertTrue(sameStateAsOpenSeaCell.equals(openSeaCell)); //symmetry
    Assert.assertEquals(openSeaCell.equals(sameStateAsOpenSeaCell) && sameStateAsOpenSeaCell.equals(yetAnotherOpenSeaCell), yetAnotherOpenSeaCell.equals(openSeaCell)); //transitivity
    Assert.assertFalse(openSeaCell.equals(diffOpenSeaCell)); //objects have different state
    Assert.assertFalse(openSeaCell.equals(nullOpenSeaCell)); // abstractShipCell is NOT null
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(openSeaCell.equals(sameRefOpenSeaCell), openSeaCell.hashCode() == sameRefOpenSeaCell.hashCode()); //same objects have the same hashCode
    Assert.assertEquals(openSeaCell.equals(sameStateAsOpenSeaCell), openSeaCell.hashCode() == sameStateAsOpenSeaCell.hashCode()); //equal objects have the same hashCode
  }

  @Test
  public void testToString() {
    Assert.assertEquals("OpenSeaCell{" +
        "isHit=" + openSeaCell.getIsHit() +
        '}', openSeaCell.toString());
  }
}