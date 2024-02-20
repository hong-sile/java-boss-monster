package bossmonster.domain;

import java.security.SecureRandom;

public class RandomBossDamageGenerator implements BossDamageGenerator {

  private static final int MAX_DAMAGE = 20;
  private static final int MIN_DAMAGE = 0;

  private final SecureRandom random = new SecureRandom();

  @Override
  public int getBossDamage() {
    return random.nextInt(MIN_DAMAGE, MAX_DAMAGE);
  }
}
