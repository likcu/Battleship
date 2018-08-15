package edu.neu.ccs.cs5004.models.ship;

/**
 * Represents a Cruiser.
 *
 */
public class Cruiser extends AbstractShip {

  /**
   * Create a new Cruiser.
   *
   * @param size     the size of Cruiser
   * @param hitCells the number of hit cells of Cruiser
   */
  public Cruiser(Integer size, Integer hitCells) {
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
    return "Cruiser{"
        + "size=" + getSize()
        + ", hitCells=" + getHitCells()
        + '}';
  }
}
