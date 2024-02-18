package bossmonster.domain;

public class Boss extends Character {

  private static final int VALID_MAX_HP_MAXIMUM = 300;
  private static final int VALID_MAX_HP_MINIMUM = 100;

  public Boss(final int maxHpValue) {
    super(new Hp(maxHpValue));
    validateMaxHp(maxHpValue);
  }

  private void validateMaxHp(final int maxHpValue) {
    if (VALID_MAX_HP_MINIMUM > maxHpValue || VALID_MAX_HP_MAXIMUM < maxHpValue) {
      throw new IllegalArgumentException("보스 몬스터 초기 HP는 100이상 300이하여야합니다.");
    }
  }
}
