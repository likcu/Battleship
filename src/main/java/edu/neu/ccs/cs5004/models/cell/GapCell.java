package edu.neu.ccs.cs5004.models.cell;

import edu.neu.ccs.cs5004.models.Cell;
import edu.neu.ccs.cs5004.view.ConsolePrinter;

/**
 * Represents a GapCell.
 *
 */
public class GapCell extends AbstractWaterCell {

  /**
   * Create a new GapCell.
   *
   * @param isHit if the GapCell was or was not hit
   */
  public GapCell(Boolean isHit) {
    super(isHit);
  }

  /**
   * Returns if the GapCell can be placed with a ship.
   *
   * @return if the GapCell can be placed with a ship
   */
  @Override
  public Boolean placeShipOnCell() {
    return false;
  }

  /**
   * Returns an attacked GapCell.
   *
   * @return an attacked GapCell
   */
  @Override
  public Cell attackCell() {
    return new GapCell(true);
  }

  /**
   * Use printer to print the GapCell.
   *
   * @param printer the consolePrinter
   */
  @Override
  public void prettyPrint(ConsolePrinter printer) {
    printer.toConsole(this);
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
    return "GapCell{"
        + "isHit=" + viewIsHit()
        + '}';
  }
}
