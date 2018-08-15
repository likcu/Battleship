package edu.neu.ccs.cs5004.models.cell;

import edu.neu.ccs.cs5004.models.AttackResult;
import edu.neu.ccs.cs5004.models.Cell;
import edu.neu.ccs.cs5004.models.Ship;
import edu.neu.ccs.cs5004.models.attackresult.Hit;
import edu.neu.ccs.cs5004.models.attackresult.Miss;
import edu.neu.ccs.cs5004.models.attackresult.Sunk;

/**
 * Represents an EnemyShipCell.
 */
public class EnemyShipCell extends AbstractShipCell {

  /**
   * Create a new EnemyShipCell.
   *
   * @param isHit  if the EnemyShipCell was or was not hit
   * @param isSunk if the EnemyShipCell is sunk
   */
  public EnemyShipCell(Boolean isHit, Boolean isSunk) {
    super(isHit, isSunk);
  }

  /**
   * Returns an attack result.
   *
   * @return an attack result
   */
  public AttackResult getAttackResult() {
    if (this.viewIsSunk()) {
      return new Sunk();
    } else if (this.getIsHit()) {
      return new Hit();
    } else {
      return new Miss();
    }
  }

  /**
   * Returns an attacked EnemyShipCell.
   *
   * @return an attacked EnemyShipCell
   */
  @Override
  public Cell attackCell() {
    return new EnemyShipCell(true, this.viewIsSunk());
  }

  /**
   * Returns a new EnemyShipCell marked as sunk if it belongs to a sunk ship.
   *
   * @return a new EnemyShipCell marked as sunk if it belongs to a sunk ship
   */
  @Override
  public AbstractShipCell markAsSunk() {
    if (this.viewIsSunk()) {
      return new EnemyShipCell(this.getIsHit(), this.viewIsSunk());
    } else {
      return new EnemyShipCell(this.getIsHit(), this.viewIsSunk());
    }
  }

  /**
   * Return the ship.
   *
   * @return the ship in the cell
   */
  @Override
  public Ship viewShip() {
    return null;
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
    return "EnemyShipCell{"
        + "isSunk=" + viewIsSunk()
        + ", isHit=" + viewIsHit()
        + '}';
  }


}



