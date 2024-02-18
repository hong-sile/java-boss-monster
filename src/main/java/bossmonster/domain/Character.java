package bossmonster.domain;

public abstract class Character {

  private final Hp hp;

  public Character(final Hp hp) {
    this.hp = hp;
  }

  public int getRemainHp() {
    return hp.getValue();
  }

  public boolean isDead() {
    return hp.isDead();
  }

  public void damaged(final int damage) {
    hp.decrease(damage);
  }
}
