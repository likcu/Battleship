package edu.neu.ccs.cs5004.models.attackresult;

import edu.neu.ccs.cs5004.models.AttackResult;

/**
 * Represents a Sunk.
 *
 * @author stephenxi
 */
public class Sunk implements AttackResult {

  /**
   * Creates a sunk.
   */
  public Sunk() {
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public int hashCode() {
    return 42;
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
    } else {
      return true;
    }
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String toString() {
    return "Sunk{}";
  }
}
