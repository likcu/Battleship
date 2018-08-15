package edu.neu.ccs.cs5004.models.cell;

import edu.neu.ccs.cs5004.models.AttackResult;
import edu.neu.ccs.cs5004.models.Cell;
import edu.neu.ccs.cs5004.models.CellObserver;
import edu.neu.ccs.cs5004.models.Ship;
import edu.neu.ccs.cs5004.models.ShipCell;
import edu.neu.ccs.cs5004.models.attackresult.Hit;
import edu.neu.ccs.cs5004.models.attackresult.Miss;
import edu.neu.ccs.cs5004.models.attackresult.Sunk;

import java.util.Objects;


/**
 * Represents a SpecificShipCell.
 *
 * @author stephenxi
 */
public class SpecificShipCell extends AbstractShipCell implements CellObserver {

  private Ship ship;

  /**
   * Create a new SpecificShipCell.
   *
   * @param isHit  if the SpecificShipCell was or was not hit
   * @param isSunk if the SpecificShipCell is sunk
   * @param ship   the ship of SpecificShipCell
   */
  public SpecificShipCell(Boolean isHit, Boolean isSunk, Ship ship) {
    super(isHit, isSunk);
    this.ship = ship;
  }

  /**
   * Getter for property 'ship'.
   *
   * @return Value for property 'ship'.
   */
  public Ship getShip() {
    return this.ship;
  }

  /**
   * Returns an attack result.
   *
   * @return an attack result
   */
  public AttackResult getAttackResult() {
    if (ship.isSunk()) {
      return new Sunk();
    } else if (this.viewIsHit()) {
      return new Hit();
    } else {
      return new Miss();
    }
  }

  /**
   * Returns an attacked SpecificShipCell.
   *
   * @return an attacked SpecificShipCell
   */
  @Override
  public Cell attackCell() {

    this.ship = this.ship.hitShip();
    if (this.ship.isSunk()) {
      return new SpecificShipCell(true, true, this.ship);
    } else {
      return new SpecificShipCell(true, false, this.ship);
    }
  }

  /**
   * Returns a new ship cell marked as sunk.
   *
   * @return a new ship cell marked as sunk
   */
  @Override
  public ShipCell markAsSunk() {
    this.isSunk = true;

    return this;
  }

  @Override
  public Ship viewShip() {
    return this.getShip();
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
    if (!super.equals(obj)) {
      return false;
    }
    SpecificShipCell that = (SpecificShipCell) obj;
    return Objects.equals(ship, that.ship);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), ship);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String toString() {
    return "SpecificShipCell{"
        + "ship=" + ship
        + ", isSunk=" + viewIsSunk()
        + ", isHit=" + viewIsHit()
        + '}';
  }

  @Override
  public void update(Ship observable) {
    this.isSunk = true;
  }
}
