package edu.neu.ccs.cs5004.models.cell;

import edu.neu.ccs.cs5004.models.Cell;

import java.util.Objects;

/**
 * Represents the common properties of a cell.
 */
public abstract class AbstractCell implements Cell {

  protected Boolean isHit;
  protected Boolean isSunk;

  /**
   * Creates an abstract cell.
   *
   * @param isHit if the cell was or was not hit
   */
  public AbstractCell(Boolean isHit) {
    this.isHit = isHit;
    this.isSunk = false;
  }

  /**
   * Getter for property 'isHit'.
   *
   * @return Value for property 'isHit'.
   */
  public Boolean getIsHit() {
    return this.isHit;
  }

  /**
   * Setter for property 'isHit'.
   *
   * @param hit the hit property
   */
  public void setHit(Boolean hit) {
    isHit = hit;
  }

  /**
   * Return the value for property isHit.
   *
   * @return the value for property isHit
   */
  public Boolean viewIsHit() {
    return this.getIsHit();
  }

  /**
   * Getter for property Sunk.
   *
   * @return the value for property Sunk
   */
  public Boolean getSunk() {
    return isSunk;
  }

  /**
   * Setter for property Sunk.
   *
   * @param sunk the value for property Sunk
   */
  public void setSunk(Boolean sunk) {
    this.isSunk = sunk;
  }

  /**
   * Returnt the value for Sunk.
   *
   * @return the value for Sunk
   */
  public Boolean viewIsSunk() {
    return this.getSunk();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof AbstractCell)) {
      return false;
    }
    AbstractCell that = (AbstractCell) obj;
    return Objects.equals(getIsHit(), that.getIsHit())
        && Objects.equals(isSunk, that.isSunk);
  }

  @Override
  public int hashCode() {

    return Objects.hash(getIsHit(), isSunk);
  }
}
