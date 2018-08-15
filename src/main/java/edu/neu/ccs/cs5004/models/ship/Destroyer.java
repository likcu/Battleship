package edu.neu.ccs.cs5004.models.ship;

/**
 * Represents a Destroyer.
 *
 */
public class Destroyer extends AbstractShip {

  /**
   * Create a new Destroyer.
   *
   * @param size     the size of Destroyer
   * @param hitCells the number of hit cells of Destroyer
   */
  public Destroyer(Integer size, Integer hitCells) {
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
    return "Destroyer{"
        + "size=" + getSize()
        + ", hitCells=" + getHitCells()
        + '}';
  }

}
