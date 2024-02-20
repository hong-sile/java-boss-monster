package bossmonster.domain;

public class Game {

  private final NumberGenerator numberGenerator;
  private final Player player;
  private final Boss boss;

  public Game(final Player player, final Boss boss, final NumberGenerator numberGenerator) {
    this.player = player;
    this.boss = boss;
    this.numberGenerator = numberGenerator;
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

  public void attackBoss(final AttackType attackType) {
    player.changeMp(attackType);
    boss.damaged(attackType.getDamage());
  }

  public void attackPlayer() {

  }

  public int playerRemainMp() {
    return player.getRemainMp();
  }

  public int playerRemainHp() {
    return player.getRemainHp();
  }

  public int bossRemainHp() {
    return boss.getRemainHp();
  }

  public int playerMaxMp() {
    return player.getMaxMp();
  }

  public int playerMaxHp() {
    return player.getMaxHp();
  }

  public int bossMaxHp() {
    return boss.getMaxHp();
  }
}
