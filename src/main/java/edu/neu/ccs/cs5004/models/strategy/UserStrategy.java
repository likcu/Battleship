package edu.neu.ccs.cs5004.models.strategy;

import edu.neu.ccs.cs5004.models.Game;
import edu.neu.ccs.cs5004.models.Iplayer;
import edu.neu.ccs.cs5004.models.Istrategy;
import edu.neu.ccs.cs5004.models.game.DebugMode;
import edu.neu.ccs.cs5004.models.map.Column;
import edu.neu.ccs.cs5004.models.map.Row;
import edu.neu.ccs.cs5004.view.ConsolePrinter;
import edu.neu.ccs.cs5004.view.Message;
import edu.neu.ccs.cs5004.view.MyConsolePrinter;

import java.io.IOException;

/**
 * Represents UserStrategy in our program.
 */
public class UserStrategy extends Strategy {

  ConsolePrinter consolePrinter = new MyConsolePrinter();

  /**
   * UserStrategy play.
   *
   * @param player    the first player
   * @param player2   the second player
   * @param game      the game
   * @param istrategy the strategy
   */
  public void strategyPlay(Iplayer player, Iplayer player2, Game game, Istrategy istrategy)
      throws IOException {

    if (player.endGame()) {
      ConsolePrinter.print(Message.GAME_OVER.getMessage() + player.getClass().getSimpleName());
      return;
    }

    Integer columnGuess = player.columnGuess();
    Integer rowGuess = player.rowGuess();

    while (player2.viewMap().getOccupiedCell(Row.values()[rowGuess - 1],
        Column.values()[columnGuess - 1]).viewIsHit()) {

      columnGuess = player2.columnRandomGuess();
      rowGuess = player2.rowRandomGuess();
    }

    player.updateBattleMap(player2, Row.values()[rowGuess - 1], Column.values()[columnGuess - 1]);

    ConsolePrinter.print(player.getClass().getSimpleName() + Message.TURN.getMessage());
    ConsolePrinter.print(player.getClass().getSimpleName() + Message.BATTLEMAP.getMessage());
    player.viewBattleMap().prettyPrint(consolePrinter);
    ConsolePrinter.print(player.getClass().getSimpleName() + Message.FLEETMAP.getMessage());
    player.viewMap().prettyPrint(consolePrinter);

    if (game instanceof DebugMode) {
      ConsolePrinter.print(player2.getClass().getSimpleName() + Message.BATTLEMAP.getMessage());
      player2.viewBattleMap().prettyPrint(consolePrinter);
      ConsolePrinter.print(player2.getClass().getSimpleName() + Message.FLEETMAP.getMessage());
      player2.viewMap().prettyPrint(consolePrinter);
    }

    istrategy.strategyPlay(player2, player, game, this);
  }
}

