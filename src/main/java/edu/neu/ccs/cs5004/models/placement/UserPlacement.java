package edu.neu.ccs.cs5004.models.placement;

import edu.neu.ccs.cs5004.models.Iplayer;
import edu.neu.ccs.cs5004.models.Ship;
import edu.neu.ccs.cs5004.models.cell.SpecificShipCell;
import edu.neu.ccs.cs5004.models.map.Column;
import edu.neu.ccs.cs5004.models.map.Row;
import edu.neu.ccs.cs5004.view.ConsolePrinter;
import edu.neu.ccs.cs5004.view.Message;
import edu.neu.ccs.cs5004.view.MyConsolePrinter;

import java.io.IOException;


/**
 * Represents a UserPlacement in our program.
 */
public class UserPlacement extends Placement{

  MyConsolePrinter printer = new MyConsolePrinter();
  /**
   * USER placement for both DEBUG mode and GAME mode and prints out the map.
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
      ConsolePrinter.print(Message.CURRENT_SHIP.getMessage() + ship.getClass().getSimpleName());

      String direction = player.directionInput();
      Integer column = player.columnInput(direction, size);
      Integer row = player.rowInput(direction, size);

      ConsolePrinter.print(Message.CONFIRM.getMessage() + direction
          + Message.CONFIRM_CONLUMN.getMessage() + column + Message.CONFIRM_ROW.getMessage()
          + row);
      Boolean confirm = player.confirmInput();

      while (!player.canBePlaced(Row.values()[row - 1], Column.values()[column - 1],
          size, direction)
          || !confirm) {
        ConsolePrinter.print(Message.DENIED.getMessage() + ship.getClass().getSimpleName());
        direction = player.directionInput();
        column = player.columnInput(direction, size);
        row = player.rowInput(direction, size);
        ConsolePrinter.print(Message.CONFIRM.getMessage() + direction
            + Message.CONFIRM_CONLUMN.getMessage() + column + Message.CONFIRM_ROW.getMessage()
            + row);
        confirm = player.confirmInput();
      }

      SpecificShipCell specificShipCell = player.convertToShipCell(ship);
      player.placeShipOnMap(Row.values()[row - 1], Column.values()[column - 1],
          specificShipCell, direction);

      printer.toConsole(player.viewMap());

      index++;
    }
  }


}
