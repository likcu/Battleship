package edu.neu.ccs.cs5004.view;

import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.models.Map;
import edu.neu.ccs.cs5004.models.ShipCell;
import edu.neu.ccs.cs5004.models.cell.GapCell;
import edu.neu.ccs.cs5004.models.cell.OpenSeaCell;
import edu.neu.ccs.cs5004.models.cell.SpecificShipCell;
import edu.neu.ccs.cs5004.models.map.BattleField;
import edu.neu.ccs.cs5004.models.ship.Battleship;

import static org.junit.Assert.*;

public class MyConsolePrinterTest {
  private MyConsolePrinter myConsolePrinter;
  private Map map;
  private OpenSeaCell openSeaCell;
  private OpenSeaCell openSeaCell2;
  private ShipCell shipCell;
  private GapCell gapCell;
  private GapCell gapCell2;
  private ShipCell shipCell2;
  private ShipCell shipCell3;
  private ShipCell shipCell4;

  @Before
  public void setUp() throws Exception {
    myConsolePrinter = new MyConsolePrinter();
    map = new BattleField();
    openSeaCell = new OpenSeaCell(false);
    openSeaCell2 = new OpenSeaCell(true);
    shipCell = new SpecificShipCell(false,false,new Battleship(4,0));
    gapCell = new GapCell(false);
    gapCell2 = new GapCell(true);
    shipCell2 = new SpecificShipCell(true,false,new Battleship(4,0));
    shipCell3 = new SpecificShipCell(true,true,new Battleship(4,0));
    shipCell4 = new SpecificShipCell(false,true,new Battleship(4,0));

  }

  @Test
  public void toConsole() {
    myConsolePrinter.toConsole(map);
  }

  @Test
  public void toConsole1() {
    myConsolePrinter.toConsole(openSeaCell);
    myConsolePrinter.toConsole(openSeaCell2);
  }

  @Test
  public void toConsole2() {
    myConsolePrinter.toConsole(shipCell);
    myConsolePrinter.toConsole(shipCell2);
    myConsolePrinter.toConsole(shipCell3);
    myConsolePrinter.toConsole(shipCell4);
  }

  @Test
  public void toConsole3() {
    myConsolePrinter.toConsole(gapCell);
    myConsolePrinter.toConsole(gapCell2);
  }
}