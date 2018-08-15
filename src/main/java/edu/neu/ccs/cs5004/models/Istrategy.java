package edu.neu.ccs.cs5004.models;

import java.io.IOException;

/**
 * Represents Istrategy in our program.
 */
public interface Istrategy {

  /**
   * Play the game according to corresponding strategy.
   *
   * @param player    the first player
   * @param player2   the second player
   * @param game      the game
   * @param istrategy the strategy
   */
  void strategyPlay(Iplayer player, Iplayer player2, Game game, Istrategy istrategy)
      throws IOException;

}
