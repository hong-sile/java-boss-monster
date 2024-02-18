package bossmonster.domain;

public class Round {

  private static final int INITIAL_VALUE = 0;

  private int value;

  public Round() {
    value = INITIAL_VALUE;
  }

  public void playRound() {
    value += 1;
  }

  public int getValue() {
    return value;
  }
}