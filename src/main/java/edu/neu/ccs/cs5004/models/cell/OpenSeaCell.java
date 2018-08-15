package edu.neu.ccs.cs5004.models.cell;

import edu.neu.ccs.cs5004.models.Cell;
import edu.neu.ccs.cs5004.view.ConsolePrinter;

/**
 * Represents a OpenSeaCell.
 */
public class OpenSeaCell extends AbstractWaterCell {

  /**
   * Create a new OpenSeaCell.
   *
   * @param isHit if the OpenSeaCell was or was not hit
   */
  public OpenSeaCell(Boolean isHit) {
    super(isHit);
  }

  /**
   * Returns if the OpenSeaCell can be placed with a ship.
   *
   * @return if the OpenSeaCell can be placed with a ship
   */
  @Override
  public Boolean placeShipOnCell() {
    return true;
  }

  /**
   * Returns an attacked OpenSeaCell.
   *
   * @return an attacked OpenSeaCell
   */
  @Override
  public Cell attackCell() {
    return new OpenSeaCell(true);
  }

  /**
   * Use the printer to print the OpenSeaCell.
   *
   * @param printer the ConsolePrinter object
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
    return "OpenSeaCell{" + "isHit=" + viewIsHit() + '}';
  }
}
