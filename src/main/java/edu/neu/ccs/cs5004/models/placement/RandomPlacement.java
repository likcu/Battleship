package edu.neu.ccs.cs5004.models.placement;

import edu.neu.ccs.cs5004.models.Iplayer;
import edu.neu.ccs.cs5004.models.Ship;
import edu.neu.ccs.cs5004.models.cell.SpecificShipCell;
import edu.neu.ccs.cs5004.models.map.Column;
import edu.neu.ccs.cs5004.models.map.Row;
import edu.neu.ccs.cs5004.models.player.HumanPlayer;
import edu.neu.ccs.cs5004.view.Message;
import edu.neu.ccs.cs5004.view.MyConsolePrinter;

import java.io.IOException;

/**
 * Represents a RandomPlacement in our program.
 */
public class RandomPlacement extends Placement{

  /**
   * Generates random ship placements for both DEBUG mode and GAME mode.
   *
   * @param player  the game player
   * @param shipNum the total ship number
   * @param ships   ship types
   */
  public void place(Iplayer player, Integer shipNum, Ship[] ships) throws IOException {

    int index = 0;
    while (index < shipNum) {

      Ship ship = ships[index];
      int size = ship.viewSize();

      String direction = player.directionRandomInput();
      Integer column = player.columnRandomInput(direction, size);
      Integer row = player.rowRandomInput(direction, size);

      int loop = 0;
      while (!player.canBePlaced(Row.values()[row - 1], Column.values()[column - 1],
          size, direction)) {
        direction = player.directionRandomInput();
        column = player.columnRandomInput(direction, size);
        row = player.rowRandomInput(direction, size);
        loop++;
        if (loop > 1000) {
          System.out.println(Message.RESTART.getMessage());
          return;
        }
      }

      SpecificShipCell specificShipCell = player.convertToShipCell(ship);
      player.placeShipOnMap(Row.values()[row - 1], Column.values()[column - 1],
          specificShipCell, direction);

      index++;
    }

    MyConsolePrinter printer = new MyConsolePrinter();
    if (player instanceof HumanPlayer) {
      System.out.println(Message.HUMAN_MAP.getMessage());
    } else {
      System.out.println(Message.COMPUTER_MAP.getMessage());
    }
    printer.toConsole(player.viewMap());
  }

}
