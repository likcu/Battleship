package edu.neu.ccs.cs5004.models.cell;


import edu.neu.ccs.cs5004.models.ShipCell;
import edu.neu.ccs.cs5004.view.ConsolePrinter;

/**
 * Represents the common properties of a ship cell.
 */
public abstract class AbstractShipCell extends AbstractCell implements ShipCell {

  /**
   * Creates an abstract ship cell.
   *
   * @param isHit  if the AbstractShipCell was or was not hit
   * @param isSunk if the AbstractShipCell is sunk
   */
  public AbstractShipCell(Boolean isHit, Boolean isSunk) {
    super(isHit);
    this.isSunk = isSunk;
  }

  /**
   * Returns true if the ship cell can be placed with a ship, false otherwise.
   *
   * @return if the ShipCell can be placed with a ship
   */
  @Override
  public Boolean placeShipOnCell() {
    return false;
  }

  /**
   * Returns the ship cell marked as sunk or not.
   *
   * @return the ship cell marked as sunk or not.
   */
  @Override
  public abstract ShipCell markAsSunk();

  /**
   * Use printer to print the ShipCell.
   *
   * @param printer the consolePrinter
   */
  @Override
  public void prettyPrint(ConsolePrinter printer) {
    printer.toConsole(this);
  }
}
