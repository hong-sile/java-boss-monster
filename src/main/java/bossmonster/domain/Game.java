package bossmonster.domain;

public class Game {

  private final Player player;
  private final Boss boss;

  public Game(final Player player, final Boss boss) {
    this.player = player;
    this.boss = boss;
  }

  public boolean canContinue() {
    return !(boss.isDead() && player.isDead());
  }
}
