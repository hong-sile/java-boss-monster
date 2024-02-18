package bossmonster.domain;

import java.util.Arrays;

public enum AttackType {

  PHYSICAL_ATTACK(1),
  MAGIC_ATTACK(2);

  private final int type;

  AttackType(final int type) {
    this.type = type;
  }

  public static AttackType from(final int type) {
    return Arrays.stream(AttackType.values())
        .filter(attackType -> attackType.type == type)
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("1 또는 2를 입력해주세요"));
  }
}
