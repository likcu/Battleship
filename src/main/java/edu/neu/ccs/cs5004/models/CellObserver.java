package edu.neu.ccs.cs5004.models;

/**
 * Represents CellObserver in our program.
 */
public interface CellObserver {

  /**
   * Update ship observable.
   *
   * @param observable the ship observable
   */
  void update(Ship observable);
}
