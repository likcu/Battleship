package edu.neu.ccs.cs5004.view;

/**
 * Represents all the message in our program.
 */
public enum Message {

  TEN("10"),

  MODE_CHOOSE("Choose your mode: DEBUG mode or GAME mode"),
  DEBUG("DEBUG"),
  GAME("GAME"),
  USER("USER"),
  RANDOM("RANDOM"),
  SMART("SMART"),

  TOTAL_SHIPNUM("Input the total number of ships you want to have: 1-10: "),

  SHIPTYPE_CHOOSE("Choose your type of ship BATTLESHIP, CRUISER, SUBMARINE, DESTROYER: "),
  B("BATTLESHIP"),
  C("CRUISER"),
  S("SUBMARINE"),
  D("DESTROYER"),
  VERTICAL("VERTICAL"),
  HORIZONTAL("HORIZONTAL"),

  SPECIFIC_SHIPNUM("Input the number of the "),

  SHIPNUM_WARNING("The number of ship should be 1-10."),
  TOTAL_SHIPNUM_EXCEEDS("Your total number of ships exceeds! "
      + "Message a number less than or equal to " ),
  CURRENT_SHIPNUM("The current total number of ships is: "),

  RESTART("invalid debug pattern, you need to restart."),
  HUMAN_MAP("Human player map:"),
  COMPUTER_MAP("Computer map:"),
  CURRENT_SHIP("current ship: "),
  CONFIRM("Confirmed (Y/N)? direction: "),
  YES("Y"),
  NO("N"),
  CONFIRM_ROW(", column: "),
  CONFIRM_CONLUMN(", row: "),
  DENIED("cannot place here or denied. set the "),

  DIRECTION("direction: "),
  COLUMN("column: "),
  ROW("row: "),
  WRONG_COLUMN("column should be A-J"),
  WRONG_ROW("row should be 1-10"),
  CHECK_DIRECTION("direction should be either vertical or horizontal"),
  ROW_GUESS("Make your row guess 1-10: "),
  COLUMN_GUESS("Make your column guess A-J: "),

  GAME_OVER("Game over, the winner is "),
  TURN(" turn: "),
  BATTLEMAP(" battle map: "),
  FLEETMAP(" fleet map: "),

  COMPUTER_STRATEGY("Choose strategy for Computer: SMART strategy or RANDOM strategy"),
  HUMAN_STRATEGY("Choose strategy for Human: USER strategy or RANDOM strategy");


  private String message;

  Message(String message) {
    this.message = message;
  }

  public String getMessage() {

    return this.message;
  }

  public void printMessage() {

    System.out.println(this.message);
  }
}
