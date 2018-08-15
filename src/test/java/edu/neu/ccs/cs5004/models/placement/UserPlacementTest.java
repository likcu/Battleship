package edu.neu.ccs.cs5004.models.placement;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import edu.neu.ccs.cs5004.models.Iplayer;
import edu.neu.ccs.cs5004.models.Ship;
import edu.neu.ccs.cs5004.models.player.HumanPlayer;
import edu.neu.ccs.cs5004.models.ship.Battleship;

import static org.junit.Assert.*;

public class UserPlacementTest {

  private UserPlacement userPlacement;
  private Ship[] ships = new Ship[1];
  private Iplayer iplayer;
  private Integer shipNum;


  @Before
  public void setUp() throws Exception {
    userPlacement = new UserPlacement();
    ships[0] = new Battleship(4,0);
    iplayer = new HumanPlayer();
    shipNum = 1;

  }

  @Test
  public void place() throws IOException {
//    ByteArrayInputStream in1 = new ByteArrayInputStream("VERTICAL".getBytes());
//    System.setIn(in1);
//    String direction = iplayer.directionInput();
//    ByteArrayInputStream in2 = new ByteArrayInputStream("A".getBytes());
//    System.setIn(in2);
//    Integer column = iplayer.columnInput(direction,ships[0].viewSize());
//    ByteArrayInputStream in3 = new ByteArrayInputStream("1".getBytes());
//    System.setIn(in3);
//    Integer row = iplayer.rowInput(direction,ships[0].viewSize());
//    userPlacement.place(iplayer,shipNum,ships);
  }


}