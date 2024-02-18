package bossmonster.domain;

public class Player extends Character {

  private static final int MAX_HP_MP_SUM_MAXIMUM = 200;

  private final PlayerName name;
  private final Mp mp;

  public Player(final PlayerName name, final int hp, final int mp) {
    super(new Hp(hp));
    validateHpMp(hp, mp);
    this.mp = new Mp(mp);
    this.name = name;
  }

  private void validateHpMp(final int maxHp, final int maxMp) {
    if (maxHp + maxMp > MAX_HP_MP_SUM_MAXIMUM) {
      throw new IllegalArgumentException("플레이어의 hp mp 총합은 200이하여야 합니다.");
    }
  }

  public int getRemainMp() {
    return mp.getRemain();
  }

  public int getMaxMp(){
    return mp.getMax();
  }

  public String getName() {
    return name.getValue();
  }
}
