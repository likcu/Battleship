package edu.neu.ccs.cs5004.models.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.models.ship.Destroyer;

import static org.junit.Assert.*;

public class AbstractCellTest {

  private AbstractCell abstractCell;
  private AbstractCell abstractCell2;
  private AbstractCell sameRefAbstractCell;
  private AbstractCell sameStateAsAbstractCell;
  private AbstractCell diffAbstractCell;
  private AbstractCell yetAnotherAbstractCell;
  private AbstractCell nullAbstractCell = null;

  @Before
  public void setUp() throws Exception {

    abstractCell = new OpenSeaCell(false);
    abstractCell2 = new SpecificShipCell(true, false, new Destroyer(1, 0));
    diffAbstractCell = new OpenSeaCell(true);
    sameRefAbstractCell = abstractCell;
    sameStateAsAbstractCell = new OpenSeaCell(false);
    yetAnotherAbstractCell = new OpenSeaCell(false);
  }

  @Test
  public void getIsHit() {
    Assert.assertEquals(false, abstractCell.getIsHit());
  }

  @Test
  public void equals() {
    Assert.assertTrue(abstractCell.equals(abstractCell)); // reflexivity
    Assert.assertTrue(abstractCell.equals(sameRefAbstractCell)); // trivial condition both reference the same object
    Assert.assertTrue(abstractCell.equals(sameStateAsAbstractCell)); // both objects should have the same state
    Assert.assertTrue(sameStateAsAbstractCell.equals(abstractCell)); //symmetry
    Assert.assertEquals(abstractCell.equals(sameStateAsAbstractCell) && sameStateAsAbstractCell.equals(yetAnotherAbstractCell), yetAnotherAbstractCell.equals(abstractCell)); //transitivity
    Assert.assertFalse(abstractCell.equals(diffAbstractCell)); //objects have different state
    Assert.assertFalse(abstractCell.equals(nullAbstractCell)); // abstractCell is NOT null
    Assert.assertFalse(abstractCell.equals(abstractCell2)); // different class
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(abstractCell.equals(sameRefAbstractCell), abstractCell.hashCode() == sameRefAbstractCell.hashCode()); //same objects have the same hashCode
    Assert.assertEquals(abstractCell.equals(sameStateAsAbstractCell), abstractCell.hashCode() == sameStateAsAbstractCell.hashCode()); //equal objects have the same hashCode
  }
}