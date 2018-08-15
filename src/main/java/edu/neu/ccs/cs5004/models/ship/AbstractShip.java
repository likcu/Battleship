package edu.neu.ccs.cs5004.models.ship;

import edu.neu.ccs.cs5004.models.CellObserver;
import edu.neu.ccs.cs5004.models.Ship;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * Represents the common properties of a ship.
 */
public abstract class AbstractShip implements Ship {

  /**
   * Add observer.
   *
   * @param cellObserver the cell observer
   */
  @Override
  public void addObserver(CellObserver cellObserver) {
    observers.add(cellObserver);
  }

  /**
   * Remove observer.
   *
   * @param cellObserver the cell observer
   */
  @Override
  public void removeObserver(CellObserver cellObserver) {
    observers.remove(cellObserver);
  }

  /**
   * Notify observer.
   */
  @Override
  public void notifyObservers() {
    for (CellObserver obs : observers) {
      obs.update(this);
    }

  }

  private Integer size;
  private Integer hitCells;
  private List<CellObserver> observers;

  /**
   * Creates an abstract ship.
   *
   * @param size     the size of AbstractShip
   * @param hitCells the number of hit cells of AbstractShip
   */
  public AbstractShip(Integer size, Integer hitCells) {
    this.size = size;
    this.hitCells = hitCells;
    this.observers = new ArrayList<>();
  }

  /**
   * Return the observer.
   *
   * @return the observer
   */
  public List<CellObserver> getObservers() {
    return observers;
  }

  /**
   * Returns true is the ship is sunk, false otherwise.
   *
   * @return if the AbstractShip is sunk
   */
  public Boolean isSunk() {

    if (size.equals(hitCells)) {
      notifyObservers();
    }
    return size.equals(hitCells);
  }

  /**
   * Getter for property 'size'.
   *
   * @return Value for property 'size'.
   */
  public Integer getSize() {
    return this.size;
  }

  /**
   * Getter for property 'hitCells'.
   *
   * @return Value for property 'hitCells'.
   */
  public Integer getHitCells() {
    return this.hitCells;
  }

  /**
   * Setter for hitCells.
   *
   * @param hitCells the hitCells
   */
  public void setHitCells(Integer hitCells) {
    this.hitCells = hitCells;
  }

  /**
   * Get the size of the ship.
   *
   * @return the size of the ship
   */
  @Override
  public Integer viewSize() {
    return this.getSize();
  }

  /**
   * Get the hitCells.
   *
   * @return the hitCells
   */
  @Override
  public Integer viewHitCells() {
    return this.getHitCells();
  }

  /**
   * Hit a ship.
   *
   * @return a new ship with hitCells updated
   */
  @Override
  public Ship hitShip() {
    this.setHitCells(this.viewHitCells() + 1);
    return this;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    AbstractShip ship = (AbstractShip) obj;
    return Objects.equals(size, ship.size)
        && Objects.equals(hitCells, ship.hitCells);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public int hashCode() {

    return Objects.hash(size, hitCells);
  }
}
