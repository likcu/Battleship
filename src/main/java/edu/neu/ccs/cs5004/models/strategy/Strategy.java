package edu.neu.ccs.cs5004.models.strategy;

import edu.neu.ccs.cs5004.controller.GameController;
import edu.neu.ccs.cs5004.models.Game;
import edu.neu.ccs.cs5004.models.Iplayer;
import edu.neu.ccs.cs5004.models.Istrategy;
import edu.neu.ccs.cs5004.models.game.DebugMode;
import edu.neu.ccs.cs5004.view.ConsolePrinter;
import edu.neu.ccs.cs5004.view.Message;
import edu.neu.ccs.cs5004.view.MyConsolePrinter;

import java.io.IOException;


/**
 * Presents an abstract strategy in our program.
 */
public abstract class Strategy implements Istrategy {

  /**
   * Prompts user to choose  computer strategy.
   *
   * @return a string indicating the computer strategy choice
   */
  public static String computerStrategyChoose() throws IOException {

    ConsolePrinter.print(Message.COMPUTER_STRATEGY.getMessage());
    String gameMode = GameController.readLine();

    while (!(gameMode.equals(Message.SMART.getMessage())
        || gameMode.equals(Message.RANDOM.getMessage()))) {
      ConsolePrinter.print(Message.COMPUTER_STRATEGY.getMessage());
      gameMode = GameController.readLine();
    }

    return gameMode;
  }

  /**
   * Prompts user to choose human strategy.
   *
   * @return a string indicating the human strategy choice
   */
  public static String humanStrategyChoose() throws IOException {

    ConsolePrinter.print(Message.HUMAN_STRATEGY.getMessage());
    String gameMode = GameController.readLine();

    while (!(gameMode.equals(Message.USER.getMessage())
        || gameMode.equals(Message.RANDOM.getMessage()))) {
      ConsolePrinter.print(Message.HUMAN_STRATEGY.getMessage());
      gameMode = GameController.readLine();
    }

    return gameMode;
  }

  /**
   * Print out four maps under debug mode play.
   *
   * @param player  the first player
   * @param player2 the second player
   * @param game    the game
   */
  public void debugModePrintMap(Iplayer player, Iplayer player2, Game game) {
    ConsolePrinter consolePrinter = new MyConsolePrinter();
    if (game instanceof DebugMode) {
      ConsolePrinter.print(player.getClass().getSimpleName() + Message.TURN.getMessage());
      ConsolePrinter.print(player.getClass().getSimpleName() + Message.BATTLEMAP.getMessage());
      player.viewBattleMap().prettyPrint(consolePrinter);
      ConsolePrinter.print(player.getClass().getSimpleName() + Message.FLEETMAP.getMessage());
      player.viewMap().prettyPrint(consolePrinter);
      ConsolePrinter.print(player2.getClass().getSimpleName() + Message.BATTLEMAP.getMessage());
      player2.viewBattleMap().prettyPrint(consolePrinter);
      ConsolePrinter.print(player2.getClass().getSimpleName() + Message.FLEETMAP.getMessage());
      player2.viewMap().prettyPrint(consolePrinter);
    }
  }


}
