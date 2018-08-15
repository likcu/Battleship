package edu.neu.ccs.cs5004.models.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.models.attackresult.Hit;
import edu.neu.ccs.cs5004.models.attackresult.Miss;
import edu.neu.ccs.cs5004.models.attackresult.Sunk;

public class EnemyShipCellTest {

  private EnemyShipCell enemyShipCell;
  private EnemyShipCell enemyShipCell2;
  private EnemyShipCell enemyShipCell3;
  private EnemyShipCell sameRefEnemyShipCell;
  private EnemyShipCell sameStateAsEnemyShipCell;
  private EnemyShipCell diffEnemyShipCell;
  private EnemyShipCell yetAnotherEnemyShipCell;
  private EnemyShipCell nullEnemyShipCell = null;

  @Before
  public void setUp() throws Exception {

    enemyShipCell = new EnemyShipCell(true, false);
    enemyShipCell2 = new EnemyShipCell(true, false);
    enemyShipCell3 = new EnemyShipCell(false, false);
    diffEnemyShipCell = new EnemyShipCell(true, true);
    sameRefEnemyShipCell = enemyShipCell;
    sameStateAsEnemyShipCell = new EnemyShipCell(true, false);
    yetAnotherEnemyShipCell = new EnemyShipCell(true, false);
  }

  @Test
  public void attackCell() {
    Assert.assertEquals(enemyShipCell, enemyShipCell3.attackCell());
  }

  @Test
  public void markAsSunk() {
    Assert.assertEquals(enemyShipCell2, enemyShipCell.markAsSunk());
    Assert.assertEquals(diffEnemyShipCell, diffEnemyShipCell.markAsSunk());
  }

  @Test
  public void getAtteckResult() {
    Assert.assertEquals(new Hit(), enemyShipCell.getAttackResult());
    Assert.assertEquals(new Sunk(), diffEnemyShipCell.getAttackResult());
    Assert.assertEquals(new Miss(), enemyShipCell3.getAttackResult());
  }

  @Test
  public void equals() {
    Assert.assertTrue(enemyShipCell.equals(enemyShipCell)); // reflexivity
    Assert.assertTrue(enemyShipCell.equals(sameRefEnemyShipCell)); // trivial condition both reference the same object
    Assert.assertTrue(enemyShipCell.equals(sameStateAsEnemyShipCell)); // both objects should have the same state
    Assert.assertTrue(sameStateAsEnemyShipCell.equals(enemyShipCell)); //symmetry
    Assert.assertEquals(enemyShipCell.equals(sameStateAsEnemyShipCell) && sameStateAsEnemyShipCell.equals(yetAnotherEnemyShipCell), yetAnotherEnemyShipCell.equals(enemyShipCell)); //transitivity
    Assert.assertFalse(enemyShipCell.equals(diffEnemyShipCell)); //objects have different state
    Assert.assertFalse(enemyShipCell.equals(nullEnemyShipCell)); // enemyShipCell is NOT null
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(enemyShipCell.equals(sameRefEnemyShipCell), enemyShipCell.hashCode() == sameRefEnemyShipCell.hashCode()); //same objects have the same hashCode
    Assert.assertEquals(enemyShipCell.equals(sameStateAsEnemyShipCell), enemyShipCell.hashCode() == sameStateAsEnemyShipCell.hashCode()); //equal objects have the same hashCode
  }

  @Test
  public void testToString() {
    Assert.assertEquals("EnemyShipCell{" +
        "isSunk=" + enemyShipCell.getSunk() +
        ", isHit=" + enemyShipCell.getIsHit() +
        '}', enemyShipCell.toString());
  }
}