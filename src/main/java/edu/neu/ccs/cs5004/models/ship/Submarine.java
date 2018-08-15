package edu.neu.ccs.cs5004.models.ship;

/**
 * Represents a Submarine.
 *
 */
public class Submarine extends AbstractShip {

  /**
   * Create a new Submarine.
   *
   * @param size     the size of Submarine
   * @param hitCells the number of hit cells of Submarine
   */
  public Submarine(Integer size, Integer hitCells) {
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
    return "Submarine{"
        + "size=" + getSize()
        + ", hitCells=" + getHitCells()
        + '}';
  }

}
