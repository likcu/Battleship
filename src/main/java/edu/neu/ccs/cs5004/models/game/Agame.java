package edu.neu.ccs.cs5004.models.game;

import edu.neu.ccs.cs5004.models.Game;
import edu.neu.ccs.cs5004.models.Iplacement;
import edu.neu.ccs.cs5004.models.Istrategy;
import edu.neu.ccs.cs5004.models.placement.Placement;

/**
 * Represents common properties of DebugMode and GameMode.
 */
public abstract class Agame implements Game {

  private Iplacement placement;
  private Istrategy istrategy;

  /**
   * Creates an Agame.
   *
   * @param placement the placement
   * @param istrategy the strategy
   */
  public Agame(Placement placement, Istrategy istrategy) {
    this.placement = placement;
    this.istrategy = istrategy;
  }

  /**
   * Getter for property placement.
   *
   * @return value for placement
   */
  public Iplacement getPlacement() {
    return placement;
  }

  /**
   * Getter for property strategy.
   *
   * @return the value for strategy
   */
  public Istrategy getIstrategy() {
    return istrategy;
  }

  /**
   * Setter for property placement.
   *
   * @param placement the placement
   */
  public void setPlacement(Placement placement) {
    this.placement = placement;
  }

  /**
   * Setter for Istrategy.
   *
   * @param istrategy the strategy
   */
  public void setIstrategy(Istrategy istrategy) {
    this.istrategy = istrategy;
  }
}
