package edu.neu.ccs.cs5004.models.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.models.attackresult.Miss;

public class AbstractWaterCellTest {

  private AbstractWaterCell abstractWaterCell;
  private AbstractWaterCell abstractWaterCell2;
  private AbstractWaterCell sameRefAbstractWaterCell;
  private AbstractWaterCell sameStateAsAbstractWaterCell;
  private AbstractWaterCell diffAbstractWaterCell;
  private AbstractWaterCell yetAnotherAbstractWaterCell;
  private AbstractWaterCell nullAbstractWaterCell = null;

  @Before
  public void setUp() throws Exception {

    abstractWaterCell = new OpenSeaCell(false);
    abstractWaterCell2 = new GapCell(false);
    diffAbstractWaterCell = new OpenSeaCell(true);
    sameRefAbstractWaterCell = abstractWaterCell;
    sameStateAsAbstractWaterCell = new OpenSeaCell(false);
    yetAnotherAbstractWaterCell = new OpenSeaCell(false);
  }

  @Test
  public void getAttackResult() {
    Assert.assertEquals(new Miss(), abstractWaterCell.getAttackResult());
  }

  @Test
  public void equals() {

    Assert.assertTrue(abstractWaterCell.equals(abstractWaterCell)); // reflexivity
    Assert.assertTrue(abstractWaterCell.equals(sameRefAbstractWaterCell)); // trivial condition both reference the same object
    Assert.assertTrue(abstractWaterCell.equals(sameStateAsAbstractWaterCell)); // both objects should have the same state
    Assert.assertTrue(sameStateAsAbstractWaterCell.equals(abstractWaterCell)); //symmetry
    Assert.assertEquals(abstractWaterCell.equals(sameStateAsAbstractWaterCell) && sameStateAsAbstractWaterCell.equals(yetAnotherAbstractWaterCell), yetAnotherAbstractWaterCell.equals(abstractWaterCell)); //transitivity
    Assert.assertFalse(abstractWaterCell.equals(diffAbstractWaterCell)); //objects have different state
    Assert.assertFalse(abstractWaterCell.equals(nullAbstractWaterCell)); // abstractShipCell is NOT null
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(abstractWaterCell.equals(sameRefAbstractWaterCell), abstractWaterCell.hashCode() == sameRefAbstractWaterCell.hashCode()); //same objects have the same hashCode
    Assert.assertEquals(abstractWaterCell.equals(sameStateAsAbstractWaterCell), abstractWaterCell.hashCode() == sameStateAsAbstractWaterCell.hashCode()); //equal objects have the same hashCode
  }
}