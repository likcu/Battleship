package edu.neu.ccs.cs5004.models.game;

import edu.neu.ccs.cs5004.controller.GameController;
import edu.neu.ccs.cs5004.models.Istrategy;
import edu.neu.ccs.cs5004.models.Ship;
import edu.neu.ccs.cs5004.models.placement.Placement;
import edu.neu.ccs.cs5004.models.ship.Battleship;
import edu.neu.ccs.cs5004.models.ship.Cruiser;
import edu.neu.ccs.cs5004.models.ship.Destroyer;
import edu.neu.ccs.cs5004.models.ship.Submarine;
import edu.neu.ccs.cs5004.view.Message;

import java.io.IOException;

/**
 * Represents a DebugMode in our game.
 */
public class DebugMode extends Agame {

  /**
   * Creates a DebugMode.
   *
   * @param placement the placement
   * @param istrategy the strategy
   */
  public DebugMode(Placement placement, Istrategy istrategy) {
    super(placement, istrategy);
  }

  /**
   * Determines user-defined fleet configuration under DEBUG mode.
   *
   * @return a ship array
   */
  public static Ship[] generateShips() throws IOException {
    Message.TOTAL_SHIPNUM.printMessage();
    String totalNumString = GameController.readLine();

    char[] totalNum = totalNumString.toCharArray();
    int totalShips = totalNumString.equals(Message.TEN.getMessage()) ? 10 : totalNum[0] - '1' + 1;
    while (totalShips < 1 || totalShips > 10 || (totalShips != 10 && totalNum.length != 1)) {
      Message.TOTAL_SHIPNUM.printMessage();
      totalNumString = GameController.readLine();
      totalNum = totalNumString.toCharArray();
      totalShips = totalNumString.equals(Message.TEN.getMessage()) ? 10 : totalNum[0] - '1' + 1;
    }

    Ship[] ships = new Ship[totalShips];
    Integer counter = 0;
    Integer maxShipNum = 0;

    while (counter < totalShips && maxShipNum < totalShips) {

      Message.SHIPTYPE_CHOOSE.printMessage();
      String shipType = GameController.readLine();

      while (!(shipType.equals(Message.B.getMessage()) || shipType.equals(Message.C.getMessage())
          || shipType.equals(Message.S.getMessage()) || shipType.equals(Message.D.getMessage()))) {
        Message.SHIPTYPE_CHOOSE.printMessage();
        shipType = GameController.readLine();
      }

      System.out.println(Message.SPECIFIC_SHIPNUM.getMessage() + shipType);
      String inputString = GameController.readLine();
      char[] inputNum = inputString.toCharArray();
      int shipNum = inputString.equals(Message.TEN.getMessage()) ? 10 : inputNum[0] - '1' + 1;

      while (shipNum < 1 || shipNum > 10 || (shipNum != 10 && inputNum.length != 1)) {
        Message.SHIPNUM_WARNING.printMessage();
        System.out.println(Message.SPECIFIC_SHIPNUM + shipType);
        inputNum = GameController.readLine().toCharArray();
        shipNum = inputNum[0] - '1' + 1;
      }

      maxShipNum = maxShipNum + shipNum;
      while (maxShipNum > totalShips) {
        System.out.println(Message.TOTAL_SHIPNUM_EXCEEDS.getMessage() + (totalShips - counter));
        inputNum = GameController.readLine().toCharArray();
        shipNum = inputNum[0] - '1' + 1;
        maxShipNum = counter;
      }

      int index = counter;
      while (index < counter + shipNum) {
        if (shipType.equals(Message.B.getMessage())) {
          ships[index] = new Battleship(4, 0);
        }
        if (shipType.equals(Message.C.getMessage())) {
          ships[index] = new Cruiser(3, 0);
        }
        if (shipType.equals(Message.S.getMessage())) {
          ships[index] = new Submarine(2, 0);
        }
        if (shipType.equals(Message.D.getMessage())) {
          ships[index] = new Destroyer(1, 0);
        }
        index++;
      }
      counter = counter + shipNum;
      System.out.println(Message.CURRENT_SHIPNUM.getMessage() + counter);
    }

    return ships;
  }
}
