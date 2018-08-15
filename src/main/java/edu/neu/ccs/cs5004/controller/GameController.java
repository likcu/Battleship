package edu.neu.ccs.cs5004.controller;

import edu.neu.ccs.cs5004.models.Game;
import edu.neu.ccs.cs5004.models.Iplayer;
import edu.neu.ccs.cs5004.models.Ship;
import edu.neu.ccs.cs5004.models.game.DebugMode;
import edu.neu.ccs.cs5004.models.game.GameMode;
import edu.neu.ccs.cs5004.models.placement.RandomPlacement;
import edu.neu.ccs.cs5004.models.placement.UserPlacement;
import edu.neu.ccs.cs5004.models.ship.Battleship;
import edu.neu.ccs.cs5004.models.ship.Cruiser;
import edu.neu.ccs.cs5004.models.ship.Destroyer;
import edu.neu.ccs.cs5004.models.ship.Submarine;
import edu.neu.ccs.cs5004.models.strategy.RandomStrategy;
import edu.neu.ccs.cs5004.models.strategy.SmartStrategy;
import edu.neu.ccs.cs5004.models.strategy.Strategy;
import edu.neu.ccs.cs5004.models.strategy.UserStrategy;

import edu.neu.ccs.cs5004.view.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Represents a GameController in our program.
 */
public class GameController {
  private Game human;
  private Game computer;

  /**
   * Creates a new GameController.
   *
   * @param human    the human game
   * @param computer the computer game
   */
  public GameController(Game human, Game computer) {
    this.human = human;
    this.computer = computer;
  }

  /**
   * Start the game.
   *
   * @param player  the human player
   * @param player2 the computer player
   */
  public void gameStart(Iplayer player, Iplayer player2) throws IOException {
    this.gameModeChoose(player, player2);
    this.gameStrategyChoose();
    this.gamePlay(player, player2);
  }

  /**
   * Prompts user to choose strategy.
   */
  private void gameStrategyChoose() throws IOException {
    String computer = Strategy.computerStrategyChoose();
    String human = Strategy.humanStrategyChoose();

    if (computer.equals(Message.RANDOM.getMessage())) {
      this.computer.setIstrategy(new RandomStrategy());
    } else {
      this.computer.setIstrategy(new SmartStrategy());
    }

    if (human.equals(Message.RANDOM.getMessage())) {
      this.human.setIstrategy(new RandomStrategy());
    } else {
      this.human.setIstrategy(new UserStrategy());
    }
  }

  /**
   * Start game.
   *
   * @param iplayer  human player
   * @param iplayer2 computer player
   */
  private void gamePlay(Iplayer iplayer, Iplayer iplayer2) throws IOException {
    this.human.getIstrategy().strategyPlay(iplayer, iplayer2, this.human,
                                            this.computer.getIstrategy());
  }

  /**
   * Prompts user to choose mode and ship placement.
   *
   * @param player  the human player
   * @param player2 the computer player
   */
  private void gameModeChoose(Iplayer player, Iplayer player2) throws IOException {

    String gameMode = "";

    while (!(gameMode.equals(Message.DEBUG.getMessage())
        || gameMode.equals(Message.GAME.getMessage()))) {
      Message.MODE_CHOOSE.printMessage();
      gameMode = GameController.readLine();
    }

    if (gameMode.equals(Message.GAME.getMessage())) {
      String placeShipWay = Game.placeShipWayChoose();
      while (!(placeShipWay.equals(Message.USER.getMessage())
          || placeShipWay.equals(Message.RANDOM.getMessage()))) {
        placeShipWay = Game.placeShipWayChoose();
      }

      if (placeShipWay.equals(Message.USER.getMessage())) {
        this.human = new GameMode(new UserPlacement(), null);
      } else {
        this.human = new GameMode(new RandomPlacement(), null);
      }
      this.computer = new GameMode(new RandomPlacement(), null);
      this.human.getPlacement().place(player, player.viewShips().length, player.viewShips());
      this.computer.getPlacement().place(player2, player2.viewShips().length, player2.viewShips());
    } else {
      String placeShipWay = Game.placeShipWayChoose();
      while (!(placeShipWay.equals(Message.USER.getMessage())
          || placeShipWay.equals(Message.RANDOM.getMessage()))) {
        placeShipWay = Game.placeShipWayChoose();
      }

      Ship[] ships = DebugMode.generateShips();
      Ship[] ships1 = new Ship[ships.length];
      for (int i = 0; i < ships.length; i++) {
        if (ships[i] instanceof Battleship) {
          ships1[i] = new Battleship(4, 0);
        } else if (ships[i] instanceof Cruiser) {
          ships1[i] = new Cruiser(3, 0);
        } else if (ships[i] instanceof Submarine) {
          ships1[i] = new Submarine(2, 0);
        } else {
          ships1[i] = new Destroyer(1, 0);
        }
      }
      if (placeShipWay.equals(Message.USER.getMessage())) {
        this.human = new DebugMode(new UserPlacement(), null);
      } else {
        this.human = new DebugMode(new RandomPlacement(), null);
      }

      this.computer = new DebugMode(new RandomPlacement(), null);
      this.human.getPlacement().place(player, ships.length, ships);
      this.computer.getPlacement().place(player2, ships.length, ships1);
    }
  }

  /**
   * Return a string input.
   *
   * @return a string input.
   * @throws IOException throw an exception
   */
  public static String readLine() throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    return bufferedReader.readLine().toUpperCase();
  }
}
