package edu.neu.ccs.cs5004.controller;

import edu.neu.ccs.cs5004.models.Iplayer;
import edu.neu.ccs.cs5004.models.player.ComputerPlayer;
import edu.neu.ccs.cs5004.models.player.HumanPlayer;

import java.io.IOException;

/**
 * Main function.
 */
public class GameStart {

  /**
   * Main function.
   *
   * @param args arguments
   * @throws IOException throws an exception
   */
  public static void main(String[] args) throws IOException {
    Iplayer player = new HumanPlayer();
    Iplayer player2 = new ComputerPlayer();
    GameController gameController = new GameController(null, null);
    gameController.gameStart(player, player2);
  }
}
