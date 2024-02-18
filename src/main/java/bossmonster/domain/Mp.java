package bossmonster.domain;

public class Mp {

  private final int max;
  private int value;

  public Mp(final int max) {
    validateMax(max);
    this.max = max;
    this.value = max;
  }

  private void validateMax(final int max) {
    if (max < 0) {
      throw new IllegalArgumentException("최대 마나는 0미만일 수 없습니다.");
    }
  }

  public int getMax() {
    return max;
  }

  public int getRemain() {
    return value;
  }
}
