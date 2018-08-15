package edu.neu.ccs.cs5004.models.ship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BattleshipTest {

  private Battleship battleship;
  private Battleship battleship2;
  private Battleship sameRefBattleship;
  private Battleship sameStateAsBattleship;
  private Battleship diffBattleship;
  private Battleship yetAnotherBattleship;
  private Battleship nullBattleship = null;

  @Before
  public void setUp() throws Exception {

    battleship = new Battleship(4, 2);
    battleship2 = new Battleship(4, 3);
    diffBattleship = new Battleship(4, 3);
    sameRefBattleship = battleship;
    sameStateAsBattleship = new Battleship(4, 2);
    yetAnotherBattleship = new Battleship(4, 2);
  }

  @Test
  public void hitShip() {
    Assert.assertEquals(battleship2, battleship.hitShip());
  }

  @Test
  public void equals() {
    Assert.assertTrue(battleship.equals(battleship)); // reflexivity
    Assert.assertTrue(battleship.equals(sameRefBattleship)); // trivial condition both reference the same object
    Assert.assertTrue(battleship.equals(sameStateAsBattleship)); // both objects should have the same state
    Assert.assertTrue(sameStateAsBattleship.equals(battleship)); //symmetry
    Assert.assertEquals(battleship.equals(sameStateAsBattleship) && sameStateAsBattleship.equals(yetAnotherBattleship), yetAnotherBattleship.equals(battleship)); //transitivity
    Assert.assertFalse(battleship.equals(diffBattleship)); //objects have different state
    Assert.assertFalse(battleship.equals(nullBattleship)); // abstractShipCell is NOT null
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(battleship.equals(sameRefBattleship), battleship.hashCode() == sameRefBattleship.hashCode()); //same objects have the same hashCode
    Assert.assertEquals(battleship.equals(sameStateAsBattleship), battleship.hashCode() == sameStateAsBattleship.hashCode()); //equal objects have the same hashCode
  }
  @Test
  public void testToString() {
    Assert.assertEquals("Battleship{" +
        "size=" + battleship.getSize() +
        ", hitCells=" + battleship.getHitCells() +
        '}', battleship.toString());
  }
}