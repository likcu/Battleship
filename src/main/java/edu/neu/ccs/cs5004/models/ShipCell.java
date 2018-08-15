package edu.neu.ccs.cs5004.models;

/**
 * Represents a ship cell.
 */
public interface ShipCell extends Cell {

  /**
   * Returns the AbstractShipCell marked as sunk.
   *
   * @return the AbstractShipCell marked as sunk
   */
  ShipCell markAsSunk();

  /**
   * Get the value for property IsSunk.
   *
   * @return the value for IsSunk
   */
  Boolean viewIsSunk();

  /**
   * Get the value for property ship.
   *
   * @return the value for property ship
   */
  Ship viewShip();

}
