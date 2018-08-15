package edu.neu.ccs.cs5004.models.player;

import edu.neu.ccs.cs5004.controller.GameController;
import edu.neu.ccs.cs5004.models.Cell;
import edu.neu.ccs.cs5004.models.CellObserver;
import edu.neu.ccs.cs5004.models.Iplayer;
import edu.neu.ccs.cs5004.models.Map;
import edu.neu.ccs.cs5004.models.Ship;
import edu.neu.ccs.cs5004.models.cell.GapCell;
import edu.neu.ccs.cs5004.models.cell.SpecificShipCell;
import edu.neu.ccs.cs5004.models.map.Column;
import edu.neu.ccs.cs5004.models.map.Row;
import edu.neu.ccs.cs5004.view.ConsolePrinter;
import edu.neu.ccs.cs5004.view.Message;

import java.io.IOException;
import java.util.Random;

/**
 * Represents an abstract Player in our battleship program.
 */
public abstract class Player implements Iplayer {

  private Map fleetMap;
  private Map battleMap; //For players to store the results of guesses.
  private Ship[] ships;

  /**
   * Creates a new Player object.
   */
  public Player() {
    this.fleetMap = Map.createMap();
    this.battleMap = Map.createMap();
    this.ships = Ship.createShips();
  }

  /**
   * Getter for property 'map'.
   *
   * @return value for property 'map'
   */
  public Map getMap() {
    return this.fleetMap;
  }

  /**
   * Getter for property 'battleMap'.
   *
   * @return value for property 'battleMap'
   */
  public Map getBattleMap() {
    return this.battleMap;
  }

  /**
   * Gets current map.
   *
   * @return current map array
   */
  public Map viewMap() {
    return this.getMap();
  }

  /**
   * Gets current battle map.
   *
   * @return value for property 'battleMap'
   */
  public Map viewBattleMap() {
    return this.getBattleMap();
  }

  /**
   * Getter for property 'ships'.
   *
   * @return value for property 'ships'
   */
  public Ship[] getShips() {
    return this.ships;
  }

  /**
   * Gets current ship array.
   *
   * @return a ship array
   */
  public Ship[] viewShips() {
    return this.getShips();
  }

  /**
   * Converts ship to specificShipCell.
   *
   * @param ship the given ship object
   * @return a specificShipCell
   */
  public SpecificShipCell convertToShipCell(Ship ship) {
    return new SpecificShipCell(false, false, ship);
  }

  /**
   * Returns true if the ship can be placed on given cell, false otherwise.
   *
   * @param row       the given row
   * @param column    the given column
   * @param size      the ship size
   * @param direction the ship direction
   * @return true if the ship can be placed on given cell, false otherwise
   */
  public Boolean canBePlaced(Row row, Column column, Integer size, String direction) {
    int index = 0;
    int rowNum = row.ordinal();
    int columnNum = column.ordinal();

    while (index < size) {

      if (direction.equals(Message.VERTICAL.getMessage())) {
        if (this.fleetMap.getOccupiedCell(Row.values()[rowNum],
            Column.values()[columnNum]).placeShipOnCell()) {
          rowNum++;
          index++;
        } else {
          return false;
        }
      }

      if (direction.equals(Message.HORIZONTAL.getMessage())) {
        if (this.fleetMap.getOccupiedCell(Row.values()[rowNum],
            Column.values()[columnNum]).placeShipOnCell()) {
          columnNum++;
          index++;
        } else {
          return false;
        }
      }
    }

    return true;
  }

  /**
   * Places ship on map.
   *
   * @param row              the given row
   * @param column           the given column
   * @param specificShipCell the specificShipCell
   * @param direction        the ship direction
   */
  public void placeShipOnMap(Row row, Column column, SpecificShipCell specificShipCell,
                             String direction) {

    int size = specificShipCell.viewShip().viewSize();
    int rowNum = row.ordinal();
    int columnNum = column.ordinal();

    if (direction.equals(Message.VERTICAL.getMessage())) {
      while (size > 0) {
        this.fleetMap.setNewCell(Row.values()[rowNum], column, specificShipCell);
        rowNum++;
        size--;
      }

    } else if (direction.equals(Message.HORIZONTAL.getMessage())) {
      while (size > 0) {
        this.fleetMap.setNewCell(row, Column.values()[columnNum], specificShipCell);
        columnNum++;
        size--;
      }
    }

    placeGapCellOnMap(row, column, direction, specificShipCell.viewShip());
  }

  /**
   * Places gapCell around specificShipCell.
   *
   * @param row       the given row
   * @param column    the given column
   * @param direction the ship direction
   * @param ship      the ship object
   */
  private void placeGapCellOnMap(Row row, Column column, String direction, Ship ship) {

    int size = ship.viewSize();
    int rowNum = row.ordinal();
    int columnNum = column.ordinal();

    if (direction.equals(Message.VERTICAL.getMessage())) {
      if (rowNum != 0) {
        this.fleetMap.setNewCell(Row.values()[rowNum - 1], Column.values()[columnNum],
            new GapCell(false));
      }
      if (rowNum + size < 10) {
        this.fleetMap.setNewCell(Row.values()[rowNum + size], Column.values()[columnNum],
            new GapCell(false));
      }

      if (columnNum != 0) {
        for (int i = 0; i < size; i++) {
          this.fleetMap.setNewCell(Row.values()[rowNum + i], Column.values()[columnNum - 1],
              new GapCell(false));
        }
      }
      if (columnNum + 1 < 10) {
        for (int i = 0; i < size; i++) {
          this.fleetMap.setNewCell(Row.values()[rowNum + i], Column.values()[columnNum + 1],
              new GapCell(false));
        }
      }

    } else if (direction.equals(Message.HORIZONTAL.getMessage())) {
      if (columnNum != 0) {
        this.fleetMap.setNewCell(Row.values()[rowNum], Column.values()[columnNum - 1],
            new GapCell(false));
      }
      if (columnNum + size < 10) {
        this.fleetMap.setNewCell(Row.values()[rowNum], Column.values()[columnNum + size],
            new GapCell(false));
      }

      if (rowNum != 0) {
        for (int i = 0; i < size; i++) {
          this.fleetMap.setNewCell(Row.values()[rowNum - 1], Column.values()[columnNum + i],
              new GapCell(false));
        }
      }
      if (rowNum + 1 < 10) {
        for (int i = 0; i < size; i++) {
          this.fleetMap.setNewCell(Row.values()[rowNum + 1], Column.values()[columnNum + i],
              new GapCell(false));
        }
      }

    }
  }

  /**
   * Randomly generates ship direction.
   *
   * @return ship direction
   */
  public String directionRandomInput() throws IOException {
    int random = Math.random() > 0.5 ? 1 : 0;
    return random == 1 ? Message.HORIZONTAL.getMessage() : Message.VERTICAL.getMessage();
  }

  /**
   * Randomly generates column number.
   *
   * @param direction the ship direction
   * @param size      the ship size
   * @return the column number
   */
  public Integer columnRandomInput(String direction, Integer size) throws IOException {
    Random random = new Random();
    int column = random.nextInt(10) + 1;
    while (direction.equals(Message.HORIZONTAL.getMessage()) && column + size > 11) {
      column = random.nextInt(10) + 1;
    }
    return column;
  }

  /**
   * Randomly generates row number.
   *
   * @param direction the ship direction
   * @param size      the ship size
   * @return the row number
   */
  public Integer rowRandomInput(String direction, Integer size) throws IOException {
    Random random = new Random();
    int row = random.nextInt(10) + 1;
    while (direction.equals(Message.VERTICAL.getMessage()) && row + size > 11) {
      row = random.nextInt(10) + 1;
    }
    return row;
  }

  /**
   * Gets direction input from user.
   *
   * @return ship direction
   */
  public String directionInput() throws IOException {

    ConsolePrinter.print(Message.DIRECTION.getMessage());
    String direction = GameController.readLine();
    while (!(direction.equals(Message.VERTICAL.getMessage())
        || direction.equals(Message.HORIZONTAL.getMessage()))) {
      ConsolePrinter.print(Message.CHECK_DIRECTION.getMessage());
      ConsolePrinter.print(Message.DIRECTION.getMessage());
      direction = GameController.readLine();
    }
    return direction;
  }

  /**
   * Gets column input from user.
   *
   * @param direction the ship direction
   * @param size      the ship size
   * @return the column
   */
  public Integer columnInput(String direction, Integer size) throws IOException {
    ConsolePrinter.print(Message.COLUMN.getMessage());
    char[] inputColumn = GameController.readLine().toCharArray();
    int column;
    if (inputColumn.length == 0) {
      column = 0;
    } else {
      column = inputColumn[0] - 'A' + 1;
    }
    while (column < 1 || column > 10 || inputColumn.length != 1
        || (direction.equals(Message.HORIZONTAL.getMessage()) && column + size > 11)) {
      ConsolePrinter.print(Message.WRONG_COLUMN.getMessage());
      ConsolePrinter.print(Message.COLUMN.getMessage());
      inputColumn = GameController.readLine().toCharArray();
      column = inputColumn[0] - 'A' + 1;
    }
    return column;
  }

  /**
   * Gets row input from user.
   *
   * @param direction the ship direction
   * @param size      the ship size
   * @return the row
   */
  public Integer rowInput(String direction, Integer size) throws IOException {
    ConsolePrinter.print(Message.ROW.getMessage());
    String inputString = GameController.readLine();
    char[] inputRow = inputString.toCharArray();
    int row;
    if (inputRow.length == 0) {
      row = 0;
    } else {
      row = inputString.equals(Message.TEN.getMessage()) ? 10 : inputRow[0] - '1' + 1;
    }
    while (row < 1 || row > 10 || (row != 10 && inputRow.length != 1)
        || (direction.equals(Message.VERTICAL.getMessage()) && row + size > 11)) {
      ConsolePrinter.print(Message.WRONG_ROW.getMessage());
      ConsolePrinter.print(Message.ROW.getMessage());
      inputRow = GameController.readLine().toCharArray();
      row = inputRow[0] - '1' + 1;
    }
    return row;
  }

  /**
   * Ask user to guess row.
   *
   * @return the row number
   */
  public Integer rowGuess() throws IOException {
    ConsolePrinter.print(Message.ROW_GUESS.getMessage());
    String inputString = GameController.readLine();
    char[] inputRow = inputString.toCharArray();
    int rowGuess;
    if (inputRow.length == 0) {
      rowGuess = 0;
    } else {
      rowGuess = inputString.equals(Message.TEN.getMessage()) ? 10 : inputRow[0] - '1' + 1;
    }
    while (rowGuess < 1 || rowGuess > 10 || (rowGuess != 10 && inputRow.length != 1)) {
      ConsolePrinter.print(Message.WRONG_ROW.getMessage());
      ConsolePrinter.print(Message.ROW.getMessage());
      inputRow = GameController.readLine().toCharArray();
      rowGuess = inputRow[0] - '1' + 1;
    }

    return rowGuess;
  }

  /**
   * Ask user to guess column.
   *
   * @return the column number
   */
  public Integer columnGuess() throws IOException {
    ConsolePrinter.print(Message.COLUMN_GUESS.getMessage());
    char[] inputColumn = GameController.readLine().toCharArray();
    int columnGuess;
    if (inputColumn.length == 0) {
      columnGuess = 0;
    } else {
      columnGuess = inputColumn[0] - 'A' + 1;
    }
    while (columnGuess < 1 || columnGuess > 10 || inputColumn.length != 1) {
      ConsolePrinter.print(Message.WRONG_COLUMN.getMessage());
      ConsolePrinter.print(Message.COLUMN.getMessage());
      inputColumn = GameController.readLine().toCharArray();
      columnGuess = inputColumn[0] - 'A' + 1;
    }

    return columnGuess;
  }

  /**
   * Returns true if user confirms input, false otherwise.
   *
   * @return true if user confirms input, false otherwise
   */
  public Boolean confirmInput() throws IOException {
    String confirm = GameController.readLine();
    if (confirm.equals(Message.YES.getMessage())) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Random generate column number for game play.
   *
   * @return the column number
   */
  public Integer columnRandomGuess() {
    Random random = new Random();
    int column = random.nextInt(10) + 1;

    return column;
  }

  /**
   * Random generate row number for game play.
   *
   * @return the row number
   */
  public Integer rowRandomGuess() {
    Random random = new Random();
    int row = random.nextInt(10) + 1;

    return row;
  }

  /**
   * Check if the guessed cell is a SpecificShipCell or not.
   *
   * @param iplayer the player
   * @param row     the row
   * @param column  the column
   * @return true if hit a SpecificShipCell, false otherwise
   */
  public Boolean successHit(Iplayer iplayer, Row row, Column column) {

    if (iplayer.viewMap().getOccupiedCell(row, column) instanceof SpecificShipCell) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Check if the number of SpecificShipCell is zero.
   *
   * @return true if the number of SpecificShipCell is zero, false otherwise
   */
  public Boolean endGame() {

    Map fleetMap = this.viewMap();
    Map battleMap = this.viewBattleMap();
    Cell[][] cells = battleMap.viewCell();
    Cell[][] cells2 = fleetMap.viewCell();
    Integer shipCellNum = 0;
    Integer shipCellNum2 = 0;

    for (int i = 0; i < cells.length; i++) {
      for (int j = 0; j < cells.length; j++) {
        if (cells[i][j] instanceof SpecificShipCell) {
          shipCellNum++;
        }
      }
    }

    for (int i = 0; i < cells.length; i++) {
      for (int j = 0; j < cells.length; j++) {
        if (cells2[i][j] instanceof SpecificShipCell) {
          shipCellNum2++;
        }
      }
    }

    return shipCellNum.equals(shipCellNum2);

  }

  /**
   * Update BattleMap.
   *
   * @param iplayer the player
   * @param row     the row
   * @param column  the column
   */
  public void updateBattleMap(Iplayer iplayer, Row row, Column column) {

    if (this.successHit(iplayer, row, column)) {
      Cell cell = iplayer.viewMap().getOccupiedCell(row, column).attackCell();
      this.battleMap.setNewCell(row, column, cell);
      iplayer.viewMap().setNewCell(row, column, cell);
      ((SpecificShipCell) iplayer.viewMap().getOccupiedCell(row, column)).getShip()
          .addObserver((CellObserver) iplayer.viewMap().getOccupiedCell(row, column));
    } else {
      Cell cell = iplayer.viewMap().getOccupiedCell(row, column).attackCell();
      this.battleMap.setNewCell(row, column, cell);
      iplayer.viewMap().setNewCell(row, column, cell);
    }
  }
}
