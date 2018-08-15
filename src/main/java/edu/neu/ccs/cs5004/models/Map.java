package edu.neu.ccs.cs5004.models;

import edu.neu.ccs.cs5004.models.map.BattleField;
import edu.neu.ccs.cs5004.models.map.Column;
import edu.neu.ccs.cs5004.models.map.Row;
import edu.neu.ccs.cs5004.view.ConsolePrinter;

/**
 * Represents a map in our program.
 */
public interface Map {

  /**
   * Returns an initial map.
   *
   * @return an initial map.
   */
  static Map createMap() {
    return new BattleField();
  }

  /**
   * Returns an occupied cell.
   *
   * @param row    the row of the map
   * @param column the column of the map
   * @return an occupied cell.
   */
  Cell getOccupiedCell(Row row, Column column);

  /**
   * Set a new cell to the position of the map.
   *
   * @param row    the row of the map
   * @param column the column of the map
   * @param cell   the cell ready to be set
   */
  void setNewCell(Row row, Column column, Cell cell);

  /**
   * use the printer to print the map.
   *
   * @param consolePrinter the printer for printing the map
   */
  void prettyPrint(ConsolePrinter consolePrinter);

  /**
   * Get the array of cells.
   *
   * @return the array of cells
   */
  Cell[][] viewCell();

  /**
   * Check if the map still has shipCell or not.
   *
   * @return true there is at least one shipCell, false otherwise
   */
  Boolean containsHit();

}
