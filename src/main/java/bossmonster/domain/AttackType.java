package bossmonster.domain;

import java.util.Arrays;

public enum AttackType {

  PHYSICAL_ATTACK(1, 10, 10),
  MAGIC_ATTACK(2, 20, -30);

  private final int type;
  private final int damage;
  private final int mpChangeValue;

  AttackType(final int type, final int damage, final int mpChangeValue) {
    this.type = type;
    this.damage = damage;
    this.mpChangeValue = mpChangeValue;
  }

  public static AttackType from(final int type) {
    return Arrays.stream(AttackType.values())
        .filter(attackType -> attackType.type == type)
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("1 또는 2를 입력해주세요"));
  }

  public int getType() {
    return type;
  }

  public int getDamage() {
    return damage;
  }

  public int getMpChangeValue() {
    return mpChangeValue;
  }
}
