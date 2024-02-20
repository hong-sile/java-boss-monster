package bossmonster.fake;

import bossmonster.domain.BossDamageGenerator;

public class DefineBossDamageGenerator implements BossDamageGenerator {

  private final int number;

  public DefineBossDamageGenerator(final int number) {
    this.number = number;
  }

  @Override
  public int getBossDamage() {
    return number;
  }
}
