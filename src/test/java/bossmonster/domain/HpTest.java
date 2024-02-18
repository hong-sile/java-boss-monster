package bossmonster.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class HpTest {

  @Test
  void hp를_감소시킨다() {
    //given
    final int maxHp = 200;
    final int damage = 100;
    final Hp hp = new Hp(maxHp);
    //when
    hp.decrease(damage);
    //then
    assertThat(hp.getValue())
        .isEqualTo(maxHp - damage);
  }
}
