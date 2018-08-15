package edu.neu.ccs.cs5004.models.game;

import edu.neu.ccs.cs5004.models.Istrategy;
import edu.neu.ccs.cs5004.models.placement.Placement;

/**
 * Represents a GameMode in our program.
 */
public class GameMode extends Agame {

  /**
   * Creates a GameMode.
   *
   * @param placement the placement
   * @param istrategy the strategy
   */
  public GameMode(Placement placement, Istrategy istrategy) {
    super(placement, istrategy);
  }

}
