package edu.neu.ccs.cs5004.models.player;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import edu.neu.ccs.cs5004.models.Map;
import edu.neu.ccs.cs5004.models.Ship;
import edu.neu.ccs.cs5004.models.ShipCell;
import edu.neu.ccs.cs5004.models.cell.GapCell;
import edu.neu.ccs.cs5004.models.cell.SpecificShipCell;
import edu.neu.ccs.cs5004.models.map.Column;
import edu.neu.ccs.cs5004.models.map.Row;
import edu.neu.ccs.cs5004.models.ship.Battleship;
import edu.neu.ccs.cs5004.view.ConsolePrinter;
import edu.neu.ccs.cs5004.view.MyConsolePrinter;

import static org.junit.Assert.*;

public class PlayerTest {
  private Player player;
  private Map fleetMap;
  private Map battleMap;
  private Ship[] ships;
  private Ship ship;
  private SpecificShipCell battleShipCell;
  private GapCell gapCell;

  @Before
  public void setUp() throws Exception {
    player = new ComputerPlayer();
    fleetMap = Map.createMap();
    battleMap = Map.createMap();
    ships = Ship.createShips();
    ship = new Battleship(4,0);
    battleShipCell = new SpecificShipCell(false,false,ship);
    gapCell = new GapCell(false);
  }

  @Test
  public void getMap() {
    Assert.assertEquals(fleetMap,player.getMap());
  }

  @Test
  public void getBattleMap() {
    Assert.assertEquals(battleMap,player.getBattleMap());
  }

  @Test
  public void viewMap() {
    Assert.assertEquals(fleetMap,player.viewMap());
  }

  @Test
  public void viewBattleMap() {
    Assert.assertEquals(battleMap,player.viewBattleMap());
  }

  @Test
  public void getShips() {
    Assert.assertEquals(ships,player.getShips());
  }

  @Test
  public void viewShips() {
    Assert.assertEquals(ships,player.viewShips());
  }

  @Test
  public void convertToShipCell() {
    Assert.assertEquals(new SpecificShipCell(false,false,ship), player.convertToShipCell(ship));
  }

  @Test
  public void canBePlaced() {
    player.placeShipOnMap(Row.ONE, Column.A,battleShipCell,"VERTICAL");
    Assert.assertEquals(false,player.canBePlaced(Row.ONE,Column.A,4,"HORIZONTAL"));
    Assert.assertEquals(false,player.canBePlaced(Row.ONE,Column.B,4,"HORIZONTAL"));
    Assert.assertEquals(true,player.canBePlaced(Row.ONE,Column.C,4,"HORIZONTAL"));
    ConsolePrinter c = new MyConsolePrinter();
    player.viewMap().prettyPrint(c);
  }

  @Test
  public void placeShipOnMap() {
    player.placeShipOnMap(Row.ONE,Column.A,battleShipCell,"VERTICAL");
    Assert.assertEquals(battleShipCell,player.viewMap().getOccupiedCell(Row.ONE,Column.A));
    Assert.assertEquals(gapCell,player.viewMap().getOccupiedCell(Row.ONE,Column.B));
  }

  @Test
  public void directionRandomInput() {
    Random random = new Random(1);
    System.out.println(random);
  }

  @Test
  public void columnRandomInput() throws IOException {
    ByteArrayInputStream in = new ByteArrayInputStream("A".getBytes());
    System.setIn(in);
    Assert.assertEquals(true,player.columnRandomInput("HORIZONTAL",4) > 0);
    Assert.assertEquals(true,player.columnRandomInput("HORIZONTAL",4) < 11);
  }

  @Test
  public void rowRandomInput() throws IOException {
    ByteArrayInputStream in = new ByteArrayInputStream("A".getBytes());
    System.setIn(in);
    Assert.assertEquals(true,player.rowRandomInput("HORIZONTAL",4) > 0);
    Assert.assertEquals(true,player.rowRandomInput("HORIZONTAL",4) < 11);
  }

  @Test
  public void directionInput() throws Exception {
    ByteArrayInputStream in1 = new ByteArrayInputStream("HORIZONTAL".getBytes());
    System.setIn(in1);
    Assert.assertEquals("HORIZONTAL",player.directionInput());
  }

  @Test
  public void columnInput() throws Exception {
    Integer integer = 1;
    ByteArrayInputStream in = new ByteArrayInputStream("A".getBytes());
    System.setIn(in);
    Assert.assertEquals(integer,player.columnInput("HORIZONTAL",4));
  }

  @Test
  public void rowInput() throws IOException {
    Integer integer = 1;
    ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
    System.setIn(in);
    Assert.assertEquals(integer,player.rowInput("HORIZONTAL",4));
  }

  @Test
  public void rowGuess() throws IOException {
    Integer integer = 1;
    ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
    System.setIn(in);
    Assert.assertEquals(integer,player.rowGuess());
  }

  @Test
  public void columnGuess() throws IOException {
    Integer integer = 1;
    ByteArrayInputStream in = new ByteArrayInputStream("A".getBytes());
    System.setIn(in);
    Assert.assertEquals(integer,player.columnGuess());
  }

  @Test
  public void confirmInput() throws IOException {
    ByteArrayInputStream in = new ByteArrayInputStream("Y".getBytes());
    System.setIn(in);
    Assert.assertEquals(true,player.confirmInput());
  }

  @Test
  public void columnRandomGuess() {
    ByteArrayInputStream in = new ByteArrayInputStream("A".getBytes());
    System.setIn(in);
    Assert.assertEquals(true,player.columnRandomGuess() > 0);
    Assert.assertEquals(true,player.columnRandomGuess() < 11);
  }

  @Test
  public void rowRandomGuess() {
    ByteArrayInputStream in = new ByteArrayInputStream("A".getBytes());
    System.setIn(in);
    Assert.assertEquals(true,player.columnRandomGuess() > 0);
    Assert.assertEquals(true,player.columnRandomGuess() < 11);
  }

  @Test
  public void successHit() {
    player.placeShipOnMap(Row.ONE,Column.A,battleShipCell,"VERTICAL");
    Assert.assertEquals(true,player.successHit(player,Row.ONE,Column.A));
    Assert.assertEquals(true,player.successHit(player,Row.TWO,Column.A));
    Assert.assertEquals(false,player.successHit(player,Row.SEVEN,Column.A));
  }

  @Test
  public void endGame() {
    player.placeShipOnMap(Row.ONE,Column.A,battleShipCell,"VERTICAL");
    player.updateBattleMap(player,Row.ONE,Column.A);
    player.updateBattleMap(player,Row.TWO,Column.A);
    player.updateBattleMap(player,Row.THREE,Column.A);
    Assert.assertEquals(false,player.endGame());
    player.updateBattleMap(player,Row.FOUR,Column.A);
    Assert.assertEquals(true,player.endGame());
  }

  @Test
  public void updateBattleMap() {
    player.placeShipOnMap(Row.ONE,Column.A,battleShipCell,"VERTICAL");
    player.updateBattleMap(player,Row.ONE,Column.A);
    SpecificShipCell specificShipCell = new SpecificShipCell(true,false,ship);
    Assert.assertEquals(specificShipCell,player.getBattleMap().getOccupiedCell(Row.ONE,Column.A));
  }
}

