package bossmonster.domain;

public class Player extends Character {

  private static final int MAX_HP_MP_SUM_MAXIMUM = 200;

  private final Mp mp;

  public Player(final Hp hp, final Mp mp) {
    super(hp);
    validateHpMp(hp, mp);
    this.mp = mp;
  }

  private void validateHpMp(final Hp hp, final Mp mp) {
    if (hp.getValue() + mp.getValue() <= MAX_HP_MP_SUM_MAXIMUM) {
      throw new IllegalArgumentException("플레이어의 hp mp 총합은 200이하여야 합니다.");
    }
  }
}
