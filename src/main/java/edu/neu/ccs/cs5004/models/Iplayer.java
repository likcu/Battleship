package edu.neu.ccs.cs5004.models;

import edu.neu.ccs.cs5004.models.cell.SpecificShipCell;
import edu.neu.ccs.cs5004.models.map.Column;
import edu.neu.ccs.cs5004.models.map.Row;

import java.io.IOException;

/**
 * Represents Iplayer in our program.
 */
public interface Iplayer {
  /**
   * Get current map.
   *
   * @return current map
   */
  Map viewMap();

  /**
   * Get current battle map.
   *
   * @return current battle map
   */
  Map viewBattleMap();

  /**
   * Get current ship array.
   *
   * @return a ship array
   */
  Ship[] viewShips();

  /**
   * Get direction from user.
   *
   * @return ship direction
   */
  String directionInput() throws IOException;

  /**
   * Get column from user.
   *
   * @param direction the ship direction
   * @param size      the ship size
   * @return the column
   */
  Integer columnInput(String direction, Integer size) throws IOException;

  /**
   * Get row from user.
   *
   * @param direction the ship direction
   * @param size      the ship size
   * @return the row
   */
  Integer rowInput(String direction, Integer size) throws IOException;

  /**
   * Randomly generate ship direction.
   *
   * @return ship direction
   */
  String directionRandomInput() throws IOException;

  /**
   * Randomly generate column number.
   *
   * @param direction the ship direction
   * @param size      the ship size
   * @return the column number
   */
  Integer columnRandomInput(String direction, Integer size) throws IOException;

  /**
   * Randomly generate row number.
   *
   * @param direction the ship direction
   * @param size      the ship size
   * @return the row number
   */
  Integer rowRandomInput(String direction, Integer size) throws IOException;

  /**
   * Returns true if the ship can be placed on given cell, false otherwise.
   *
   * @param row       the given row
   * @param column    the given column
   * @param size      the ship size
   * @param direction the ship direction
   * @return true if the ship can be placed on given cell, false otherwise
   */
  Boolean canBePlaced(Row row, Column column, Integer size, String direction);

  /**
   * Convert ship to specificShipCell.
   *
   * @param ship the given ship object
   * @return a specificShipCell
   */
  SpecificShipCell convertToShipCell(Ship ship);

  /**
   * Place ship on map.
   *
   * @param row              the given row
   * @param column           the given column
   * @param specificShipCell the specificShipCell
   * @param direction        the ship direction
   */
  void placeShipOnMap(Row row, Column column, SpecificShipCell specificShipCell, String direction);

  /**
   * Return true if user confirms input, false otherwise.
   *
   * @return true if user confirms input, false otherwise
   */
  Boolean confirmInput() throws IOException;

  /**
   * Check if the guessed cell is a SpecificShipCell or not.
   *
   * @param iplayer the player
   * @param row     the row
   * @param column  the column
   * @return true if hit a SpecificShipCell, false otherwise
   */
  Boolean successHit(Iplayer iplayer, Row row, Column column);

  /**
   * Check if all SpecificShipCells are hit.
   *
   * @return true if all SpecificShipCells are hit, false otherwise
   */
  Boolean endGame();

  /**
   * Update BattleMap.
   *
   * @param iplayer the player
   * @param row     the row
   * @param column  the column
   */
  void updateBattleMap(Iplayer iplayer, Row row, Column column);

  /**
   * Ask user to guess row.
   *
   * @return the row number
   */
  Integer rowGuess() throws IOException;

  /**
   * Ask user to guess column.
   *
   * @return the column number
   */
  Integer columnGuess() throws IOException;

  /**
   * Random generate row number for game play.
   *
   * @return the row number
   */
  Integer rowRandomGuess();

  /**
   * Random generate column number for game play.
   *
   * @return the column number
   */
  Integer columnRandomGuess();
}
