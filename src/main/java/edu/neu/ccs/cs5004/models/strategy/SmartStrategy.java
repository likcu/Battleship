package edu.neu.ccs.cs5004.models.strategy;

import edu.neu.ccs.cs5004.models.Game;
import edu.neu.ccs.cs5004.models.Iplayer;
import edu.neu.ccs.cs5004.models.Istrategy;
import edu.neu.ccs.cs5004.models.cell.SpecificShipCell;
import edu.neu.ccs.cs5004.models.map.Column;
import edu.neu.ccs.cs5004.models.map.Row;
import edu.neu.ccs.cs5004.view.ConsolePrinter;
import edu.neu.ccs.cs5004.view.Message;

import java.io.IOException;



/**
 * Represents smart strategy in our program.
 */
public class SmartStrategy extends Strategy implements Istrategy {

  /**
   * Helper function for smart check.
   *
   * @param iplayer the player
   * @param row     the row
   * @param column  the column
   */
  private Boolean check(Iplayer iplayer, Integer row, Integer column) {
    if (iplayer.viewMap().getOccupiedCell(Row.values()[row], Column.values()[column]).viewIsHit()
        && iplayer.viewMap().getOccupiedCell(Row.values()[row], Column.values()[column])
        instanceof SpecificShipCell) {
      return true;
    }

    return false;
  }

  /**
   * Helper function for smart strategy.
   *
   * @param iplayer the player
   * @param row     the row
   * @param column  the column
   */
  private Boolean smartCheck(Iplayer iplayer, Integer row, Integer column) {
    if ((row < 10 && check(iplayer, row, column - 1))
        || (column < 10 && check(iplayer, row - 1, column))
        || (row > 1 && check(iplayer, row - 2, column - 1))
        || (column > 1 && check(iplayer, row - 1, column - 2))) {
      return true;
    }

    return false;
  }

  /**
   * Smart strategy play.
   *
   * @param player    the first player call the method
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

    Integer columnRandomGuess = player.columnRandomGuess();
    Integer rowRandomGuess = player.rowRandomGuess();

    while ((player2.viewMap().containsHit()
        && !smartCheck(player2, rowRandomGuess, columnRandomGuess))
        || player2.viewMap().getOccupiedCell(Row.values()[rowRandomGuess - 1],
        Column.values()[columnRandomGuess - 1]).viewIsHit()) {
      columnRandomGuess = player.columnRandomGuess();
      rowRandomGuess = player.rowRandomGuess();
    }

    player.updateBattleMap(player2, Row.values()[rowRandomGuess - 1],
        Column.values()[columnRandomGuess - 1]);

    this.debugModePrintMap(player, player2, game);

    istrategy.strategyPlay(player2, player, game, this);

  }
}
