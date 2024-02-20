package bossmonster.fake;

import bossmonster.domain.NumberGenerator;

public class DefineNumberGenerator implements NumberGenerator {

  private final int number;

  public DefineNumberGenerator(final int number) {
    this.number = number;
  }

  @Override
  public int pickNumber() {
    return number;
  }
}
