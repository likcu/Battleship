package edu.neu.ccs.cs5004.view;

import edu.neu.ccs.cs5004.models.Map;
import edu.neu.ccs.cs5004.models.ShipCell;
import edu.neu.ccs.cs5004.models.cell.GapCell;
import edu.neu.ccs.cs5004.models.cell.OpenSeaCell;

public interface ConsolePrinter {

  /**
   * Prints out message.
   *
   * @param string the message string
   */
  static void print(String string) {
    System.out.println(string);
  }

  /**
   * Print out the map.
   *
   * @param map the map
   */
  void toConsole(Map map);

  /**
   * Print out the openSeaCell.
   *
   * @param openSeaCell the openSeaCell
   */
  void toConsole(OpenSeaCell openSeaCell);

  /**
   * Print out the ShipCell.
   *
   * @param shipCell the shipCell
   */
  void toConsole(ShipCell shipCell);

  /**
   * Prints out the gapCell.
   *
   * @param gapCell the GapCell
   */
  void toConsole(GapCell gapCell);


}
