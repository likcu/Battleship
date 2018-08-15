package edu.neu.ccs.cs5004.models.map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import edu.neu.ccs.cs5004.models.Cell;
import edu.neu.ccs.cs5004.models.Map;
import edu.neu.ccs.cs5004.models.cell.GapCell;
import edu.neu.ccs.cs5004.models.cell.OpenSeaCell;
import edu.neu.ccs.cs5004.models.cell.SpecificShipCell;
import edu.neu.ccs.cs5004.models.ship.Battleship;
import edu.neu.ccs.cs5004.view.ConsolePrinter;
import edu.neu.ccs.cs5004.view.MyConsolePrinter;

import static org.junit.Assert.*;

public class BattleFieldTest {

  private Cell[][] cells;
  private Cell[][] cells2;
  private Row row;
  private Column column;
  private BattleField battleField;
  private Map battleField2;
  private BattleField sameRefBattleField;
  private BattleField sameStateAsBattleField;
  private BattleField diffBattleField;
  private BattleField yetAnotherBattleField;
  private BattleField nullBattleField = null;
  private ConsolePrinter consolePrinter;

  private Cell[][] cell3;
  private BattleField bf;

  @Before
  public void setUp() throws Exception {

    cells = new Cell[10][10];
    for (int i = 0; i < 10; i ++) {
      for (int j = 0; j < 10; j ++) {
        cells[i][j] = new OpenSeaCell(false);
      }
    }
    cells2 = new Cell[10][10];
    for (int i = 0; i < 10; i ++) {
      for (int j = 0; j < 10; j ++) {
        cells[i][j] = new OpenSeaCell(false);
      }
    }
    cells2[0][0] = new GapCell(false);

    row = Row.ONE;
    column = Column.A;
    battleField = new BattleField(cells);
    battleField2 = Map.createMap();
    diffBattleField = new BattleField(cells2);
    sameRefBattleField = battleField;
    sameStateAsBattleField = new BattleField(cells);
    yetAnotherBattleField = new BattleField(cells);
    consolePrinter = new MyConsolePrinter();

    cell3 = new Cell[10][10];
    for (int i = 0; i < 10; i ++) {
      for (int j = 0; j < 10; j ++) {
        cells[i][j] = new OpenSeaCell(false);
      }
    }
    cell3[0][0] = new SpecificShipCell(true,false,new Battleship(4,0));
    bf = new BattleField(cell3);
  }

  @Test
  public void getCell() {
    Assert.assertEquals(cells, battleField.getCell());
  }

  @Test
  public void viewCell() {
    Assert.assertEquals(cells, battleField.viewCell());
  }

  @Test
  public void getOccupiedCell() {
    Assert.assertEquals(new OpenSeaCell(false), battleField.getOccupiedCell(row, column));
    Assert.assertEquals(new GapCell(false), diffBattleField.getOccupiedCell(row, column));
  }

  @Test
  public void setNewCell() {
    battleField.setNewCell(row, column, new GapCell(false));
    Assert.assertEquals(new GapCell(false), battleField.getOccupiedCell(row, column));
  }

  @Test
  public void prettyPrint() {
    battleField.prettyPrint(consolePrinter);
    battleField2.prettyPrint(consolePrinter);
  }

  @Test
  public void equals() {
    Assert.assertTrue(battleField.equals(battleField)); // reflexivity
    Assert.assertTrue(battleField.equals(sameRefBattleField)); // trivial condition both reference the same object
    Assert.assertTrue(battleField.equals(sameStateAsBattleField)); // both objects should have the same state
    Assert.assertTrue(sameStateAsBattleField.equals(battleField)); //symmetry
    Assert.assertEquals(battleField.equals(sameStateAsBattleField) && sameStateAsBattleField.equals(yetAnotherBattleField), yetAnotherBattleField.equals(battleField)); //transitivity
    Assert.assertFalse(battleField.equals(diffBattleField)); //objects have different state
    Assert.assertFalse(battleField.equals(nullBattleField)); // abstractShipCell is NOT null
  }

  @Test
  public void testHashCode() {

    Assert.assertEquals(battleField.equals(sameRefBattleField), battleField.hashCode() == sameRefBattleField.hashCode()); //same objects have the same hashCode
    Assert.assertEquals(battleField.equals(sameStateAsBattleField), battleField.hashCode() == sameStateAsBattleField.hashCode()); //equal objects have the same hashCode
  }

  @Test
  public void testToString() {

    Assert.assertEquals(sameRefBattleField.toString(), battleField.toString());
  }

  @Test
  public void containsHit() {

    Assert.assertEquals(true,bf.containsHit());
    Assert.assertEquals(false,battleField.containsHit());
  }
}