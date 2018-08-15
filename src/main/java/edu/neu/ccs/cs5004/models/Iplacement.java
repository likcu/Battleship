package edu.neu.ccs.cs5004.models;

import java.io.IOException;

/**
 * Represents Iplacement in our program.
 */
public interface Iplacement {

  /**
   * Place ship on map.
   *
   * @param player  the player
   * @param shipNum the ship number
   * @param ships   the ship array
   */
  void place(Iplayer player, Integer shipNum, Ship[] ships) throws IOException;
}
