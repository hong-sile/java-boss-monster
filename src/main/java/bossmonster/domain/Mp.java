package bossmonster.domain;

public class Mp {

  private final int max;
  private int value;

  public Mp(final int max) {
    this.max = max;
    this.value = max;
  }

  public int getMax() {
    return max;
  }

  public int getRemain() {
    return value;
  }
}
