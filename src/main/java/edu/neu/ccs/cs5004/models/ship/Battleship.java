package edu.neu.ccs.cs5004.models.ship;

/**
 * Represents a Battleship.
 *
 */
public class Battleship extends AbstractShip {

  /**
   * Create a new Battleship.
   *
   * @param size     the size of Battleship
   * @param hitCells the number of hit cells of Battleship
   */
  public Battleship(Integer size, Integer hitCells) {
    super(size, hitCells);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String toString() {
    return "Battleship{"
        + "size=" + getSize()
        + ", hitCells=" + getHitCells()
        + '}';
  }

}
