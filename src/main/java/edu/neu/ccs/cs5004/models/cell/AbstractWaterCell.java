package edu.neu.ccs.cs5004.models.cell;

import edu.neu.ccs.cs5004.models.AttackResult;
import edu.neu.ccs.cs5004.models.Cell;
import edu.neu.ccs.cs5004.models.WaterCell;
import edu.neu.ccs.cs5004.models.attackresult.Miss;

/**
 * Represents the common properties of a water cell.
 *
 */
public abstract class AbstractWaterCell extends AbstractCell implements WaterCell {

  /**
   * Creates an abstract water cell.
   *
   * @param isHit if the AbstractWaterCell was or was not hit
   */
  public AbstractWaterCell(Boolean isHit) {
    super(isHit);
  }

  /**
   * Returns the attack result.
   *
   * @return the attack result.
   */
  @Override
  public AttackResult getAttackResult() {
    return new Miss();
  }

  /**
   * Returns the cell attacked.
   *
   * @return the cell attacked.
   */
  @Override
  public abstract Cell attackCell();

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

}
