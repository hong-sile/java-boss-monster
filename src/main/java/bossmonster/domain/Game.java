package bossmonster.domain;

public class Game {

  private final BossDamageGenerator bossDamageGenerator;
  private final Player player;
  private final Boss boss;

  public Game(final Player player, final Boss boss, final BossDamageGenerator bossDamageGenerator) {
    this.player = player;
    this.boss = boss;
    this.bossDamageGenerator = bossDamageGenerator;
  }

  public boolean canContinue() {
    return !(boss.isDead() && player.isDead());
  }

  public boolean isBossDead() {
    return boss.isDead();
  }

  public boolean isPlayerDead() {
    return player.isDead();
  }

  public int attackBoss(final AttackType attackType) {
    player.changeMp(attackType);
    final int damage = attackType.getDamage();
    boss.damaged(damage);
    return damage;
  }

  public int attackPlayer() {
    final int damage = bossDamageGenerator.getBossDamage();
    player.damaged(damage);
    return damage;
  }

  public Player getPlayer() {
    return player;
  }

  public Boss getBoss() {
    return boss;
  }
}
