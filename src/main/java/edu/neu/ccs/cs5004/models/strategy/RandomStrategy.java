package edu.neu.ccs.cs5004.models.strategy;

import edu.neu.ccs.cs5004.models.Game;
import edu.neu.ccs.cs5004.models.Iplayer;
import edu.neu.ccs.cs5004.models.Istrategy;
import edu.neu.ccs.cs5004.models.game.DebugMode;
import edu.neu.ccs.cs5004.models.map.Column;
import edu.neu.ccs.cs5004.models.map.Row;
import edu.neu.ccs.cs5004.models.player.HumanPlayer;
import edu.neu.ccs.cs5004.view.ConsolePrinter;
import edu.neu.ccs.cs5004.view.Message;
import edu.neu.ccs.cs5004.view.MyConsolePrinter;

import java.io.IOException;


/**
 * Represents a Random strategy in our program.
 */
public class RandomStrategy extends Strategy {

  ConsolePrinter consolePrinter = new MyConsolePrinter();

  /**
   * Random strategy play.
   *
   * @param player    the player
   * @param player2   the second player
   * @param game      the game
   * @param istrategy the strategy
   */
  public void strategyPlay(Iplayer player, Iplayer player2, Game game, Istrategy istrategy)
      throws IOException {

    //Check lose and win and BREAK, otherwise CONTINUE the game.
    if (player.endGame()) {
      ConsolePrinter.print(Message.GAME_OVER.getMessage() + player.getClass().getSimpleName());
      return;
    }

    Integer columnRandomGuess = player.columnRandomGuess();
    Integer rowRandomGuess = player.rowRandomGuess();

    //If the cell is already guessed, ask COMPUTER to do another guess.
    while (player2.viewMap().getOccupiedCell(Row.values()[rowRandomGuess - 1],
        Column.values()[columnRandomGuess - 1]).viewIsHit()) {

      columnRandomGuess = player2.columnRandomGuess();
      rowRandomGuess = player2.rowRandomGuess();
    }

    player.updateBattleMap(player2, Row.values()[rowRandomGuess - 1],
        Column.values()[columnRandomGuess - 1]);

    if (player instanceof HumanPlayer && !(game instanceof DebugMode)) {
      ConsolePrinter.print(player.getClass().getSimpleName() + Message.TURN.getMessage());
      ConsolePrinter.print(player.getClass().getSimpleName() + Message.BATTLEMAP.getMessage());
      player.viewBattleMap().prettyPrint(consolePrinter);
      ConsolePrinter.print(player.getClass().getSimpleName() + Message.FLEETMAP.getMessage());
      player.viewMap().prettyPrint(consolePrinter);
    }

    this.debugModePrintMap(player, player2, game);

    istrategy.strategyPlay(player2, player, game, this);

  }
}