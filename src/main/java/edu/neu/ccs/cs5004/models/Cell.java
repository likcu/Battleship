package edu.neu.ccs.cs5004.models;

import edu.neu.ccs.cs5004.view.ConsolePrinter;

/**
 * Represents a cell in the program.
 */
public interface Cell {

  /**
   * Returns the attack result.
   *
   * @return the attack result
   */
  AttackResult getAttackResult();

  /**
   * Returns the cell attacked.
   *
   * @return the cell attacked.
   */
  Cell attackCell();

  /**
   * Returns true if the cell can be placed with a ship, false otherwise.
   *
   * @return true if the cell can be placed with a ship, false otherwise.
   */
  Boolean placeShipOnCell();

  /**
   * Return true if the cell is hit, false otherwise.
   *
   * @return true if the cell is hit, false otherwise
   */
  Boolean viewIsHit();

  /**
   * Get the value for property IsSunk.
   *
   * @return the value for property IsSunk
   */
  Boolean viewIsSunk();

  /**
   * Print out Cell.
   *
   * @param consolePrinter the printer
   */
  void prettyPrint(ConsolePrinter consolePrinter);
}
