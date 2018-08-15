package edu.neu.ccs.cs5004.view;

import edu.neu.ccs.cs5004.models.Map;
import edu.neu.ccs.cs5004.models.ShipCell;
import edu.neu.ccs.cs5004.models.cell.GapCell;
import edu.neu.ccs.cs5004.models.cell.OpenSeaCell;
import edu.neu.ccs.cs5004.models.map.BattleField;
import edu.neu.ccs.cs5004.models.map.Column;
import edu.neu.ccs.cs5004.models.map.Row;

/**
 * Represents a console printer.
 */
public class MyConsolePrinter implements ConsolePrinter {

  /**
   * Print the map in the console.
   *
   * @param map the map ready for printing
   */
  public void toConsole(Map map) {

    ConsolePrinter consolePrinter = new MyConsolePrinter();

    System.out.print("    A  B  C  D  E  F  G  H  I  J\n");
    System.out.print("    —————————————————————————————\n");

    for (int i = 1; i <= BattleField.LENGTH; i++) {
      if (i != BattleField.LENGTH) {
        System.out.print("0" + i + " |");
      } else {
        System.out.print(i + " |");
      }

      for (int j = 1; j <= BattleField.LENGTH; j++) {

        (map.getOccupiedCell(Row.values()[i - 1], Column.values()[j - 1]))
            .prettyPrint(consolePrinter);

        if (j == BattleField.LENGTH) {
          System.out.print("\n");
        }
      }
    }
    System.out.println("    —————————————————————————————\n");
  }


  /**
   * Prints out the OpenSeaCell.
   *
   * @param openSeaCell the openSeaCell
   */
  @Override
  public void toConsole(OpenSeaCell openSeaCell) {
    if (openSeaCell.viewIsHit()) {
      System.out.print("--|");
    } else {
      System.out.print("  |");
    }
  }

  /**
   * Prints out the ShipCell.
   *
   * @param shipCell the shipCell
   */
  @Override
  public void toConsole(ShipCell shipCell) {
    if (!shipCell.viewIsHit() && !shipCell.viewIsSunk()) {
      System.out.print("<>|");
    } else if (shipCell.viewIsSunk()) {
      System.out.print("oo|");
    } else if (shipCell.viewIsHit() && !shipCell.viewIsSunk()) {
      System.out.print("//|");
    }
  }

  /**
   * Prints out the GapCell.
   *
   * @param gapCell the GapCell
   */
  @Override
  public void toConsole(GapCell gapCell) {
    if (gapCell.viewIsHit()) {
      System.out.print("--|");
    } else {
      System.out.print("xx|");
    }
  }

}
