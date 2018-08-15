package edu.neu.ccs.cs5004.models.map;

import edu.neu.ccs.cs5004.models.Cell;
import edu.neu.ccs.cs5004.models.Map;
import edu.neu.ccs.cs5004.models.cell.OpenSeaCell;
import edu.neu.ccs.cs5004.models.cell.SpecificShipCell;
import edu.neu.ccs.cs5004.view.ConsolePrinter;

import java.util.Arrays;


/**
 * Represents a battle field.
 */
public class BattleField implements Map {

  public static final Integer LENGTH = 10;
  private Cell[][] cell;

  /**
   * Creates a battle field.
   *
   * @param cell the cell array in the battle field
   */
  public BattleField(Cell[][] cell) {
    this.cell = new Cell[LENGTH][LENGTH];

    for (int i = 0; i < LENGTH; i++) {
      for (int j = 0; j < LENGTH; j++) {
        this.cell[i][j] = cell[i][j];
      }
    }
  }

  /**
   * Creates a battle field.
   */
  public BattleField() {
    cell = new Cell[LENGTH][LENGTH];

    for (int i = 0; i < LENGTH; i++) {
      for (int j = 0; j < LENGTH; j++) {
        this.cell[i][j] = new OpenSeaCell(false);
      }
    }
  }

  /**
   * Getter for property 'cell'.
   *
   * @return Value for property 'cell'.
   */
  public Cell[][] getCell() {
    Cell[][] cells = new Cell[LENGTH][LENGTH];

    for (int i = 0; i < LENGTH; i++) {
      for (int j = 0; j < LENGTH; j++) {
        cells[i][j] = this.cell[i][j];
      }
    }
    return cells;
  }

  /**
   * Get the array of cells.
   *
   * @return the array of cells
   */
  public Cell[][] viewCell() {
    return this.getCell();
  }

  /**
   * Returns an occupied cell.
   *
   * @param row    the row of the map
   * @param column the column of the map
   * @return an occupied cell.
   */
  public Cell getOccupiedCell(Row row, Column column) {
    return this.cell[row.ordinal()][column.ordinal()];
  }

  /**
   * Check if the map still has shipCell or not.
   *
   * @return true there is at least one shipCell, false otherwise
   */
  public Boolean containsHit() {

    for (int i = 0; i < LENGTH; i++) {
      for (int j = 0; j < LENGTH; j++) {
        if (this.cell[i][j] instanceof SpecificShipCell && this.cell[i][j].viewIsHit()
            && !this.cell[i][j].viewIsSunk()) {
          return true;
        }
      }
    }

    return false;
  }

  /**
   * Set a new cell to the position of the map.
   *
   * @param row    the row of the map
   * @param column the column of the map
   * @param cell   the cell ready to be set
   */
  public void setNewCell(Row row, Column column, Cell cell) {
    this.cell[row.ordinal()][column.ordinal()] = cell;
  }

  /**
   * use the printer to print the map.
   *
   * @param printer the printer for printing the map
   */
  public void prettyPrint(ConsolePrinter printer) {
    printer.toConsole(this);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof BattleField)) {
      return false;
    }
    BattleField that = (BattleField) obj;
    for (Row row : Row.values()) {
      for (Column column : Column.values()) {
        if (!this.cell[row.ordinal()][column.ordinal()].getClass()
            .equals(that.cell[row.ordinal()][column.ordinal()].getClass())) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public int hashCode() {
    return Arrays.deepHashCode(getCell());
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String toString() {
    return "BattleField{"
        + "cell=" + Arrays.toString(cell)
        + '}';
  }

}
