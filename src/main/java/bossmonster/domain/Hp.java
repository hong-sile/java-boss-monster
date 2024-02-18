package bossmonster.domain;

public class Hp {

  private final int max;
  private int remain;

  public Hp(final int max) {
    this.max = max;
    this.remain = max;
  }

  public boolean isDead() {
    return remain <= 0;
  }

  public int getMax() {
    return max;
  }

  public int getRemain() {
    return remain;
  }

  public void decrease(final int value) {
    this.remain -= value;
  }
}
