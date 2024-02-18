package bossmonster.domain;

public class Hp {

  private final int max;
  private int remain;

  public Hp(final int max) {
    validateMax(max);
    this.max = max;
    this.remain = max;
  }

  private void validateMax(final int max) {
    if (max <= 0) {
      throw new IllegalArgumentException("최대 체력은 0이하일 수 없습니다.");
    }
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
