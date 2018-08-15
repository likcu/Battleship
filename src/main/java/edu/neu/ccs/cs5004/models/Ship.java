package edu.neu.ccs.cs5004.models;

import edu.neu.ccs.cs5004.models.ship.Battleship;
import edu.neu.ccs.cs5004.models.ship.Cruiser;
import edu.neu.ccs.cs5004.models.ship.Destroyer;
import edu.neu.ccs.cs5004.models.ship.Submarine;

import java.util.List;

/**
 * Represents a Ship in the program.
 */
public interface Ship {

  /**
   * Creates a ship array.
   *
   * @return a ship array
   */
  static Ship[] createShips() {
    Ship[] ships = new Ship[10];
    ships[0] = new Battleship(4, 0);
    ships[1] = new Cruiser(3, 0);
    ships[2] = new Cruiser(3, 0);
    ships[3] = new Submarine(2, 0);
    ships[4] = new Submarine(2, 0);
    ships[5] = new Submarine(2, 0);
    ships[6] = new Destroyer(1, 0);
    ships[7] = new Destroyer(1, 0);
    ships[8] = new Destroyer(1, 0);
    ships[9] = new Destroyer(1, 0);

    return ships;
  }

  /**
   * Returns if the ship is sunk.
   *
   * @return if the ship is sunk
   */
  Boolean isSunk();

  /**
   * Returns the AbstractShip after hit.
   *
   * @return the AbstractShip after hit
   */
  Ship hitShip();

  /**
   * Get the size of the ship.
   *
   * @return the size of the ship
   */
  Integer viewSize();

  /**
   * Get the hitCells.
   *
   * @return the hitCells
   */
  Integer viewHitCells();

  /**
   * Add observer.
   *
   * @param cellObserver the cell observer
   */
  void addObserver(CellObserver cellObserver);

  /**
   * Remove observer.
   *
   * @param cellObserver the cell observer
   */
  void removeObserver(CellObserver cellObserver);


  /**
   * Notify observer.
   */
  void notifyObservers();

  /**
   * Return the observer.
   *
   * @return the observer
   */
  List<CellObserver> getObservers();

}
