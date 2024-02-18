package bossmonster.domain;

public class Hp {

  private final int max;
  private int value;

  public Hp(final int max) {
    this.max = max;
    this.value = max;
  }

  public boolean isDead() {
    return max <= value;
  }

  public int getMax() {
    return max;
  }

  public int getValue() {
    return value;
  }
}
