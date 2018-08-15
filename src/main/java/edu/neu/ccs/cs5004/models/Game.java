package edu.neu.ccs.cs5004.models;

import edu.neu.ccs.cs5004.controller.GameController;
import edu.neu.ccs.cs5004.models.placement.Placement;

import java.io.IOException;


/**
 * Represents a Game in our program.
 */
public interface Game {

  /**
   * Prompts user to choose ship placement method.
   *
   * @return a string
   */
  static String placeShipWayChoose() throws IOException {
    System.out.println("RANDOM or USER ship placement?");
    String mode = GameController.readLine();
    return mode;
  }

  /**
   * Getter for property placement.
   *
   * @return value for placement
   */
  Iplacement getPlacement();

  /**
   * Getter for property strategy.
   *
   * @return the value for strategy
   */
  Istrategy getIstrategy();

  /**
   * Setter for property placement.
   *
   * @param placement the placement
   */
  void setPlacement(Placement placement);

  /**
   * Setter for Istrategy.
   *
   * @param istrategy the strategy
   */
  void setIstrategy(Istrategy istrategy);
}
