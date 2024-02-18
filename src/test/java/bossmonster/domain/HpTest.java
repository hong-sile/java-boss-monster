package bossmonster.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Nested;
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
    assertThat(hp.getRemain())
        .isEqualTo(maxHp - damage);
  }

  @Nested
  class isDead {
    @Test
    void 잔여_hp가_0보다_작으면_참을_반환한다() {
      //given
      final int maxHp = 200;
      final int damage = 300;
      final Hp hp = new Hp(maxHp);
      //when
      hp.decrease(damage);
      //then
      assertThat(hp.isDead())
          .isTrue();
    }

    @Test
    void 잔여_hp가_0보다_크면_거짓을_반환한다() {
      //given
      final int maxHp = 200;
      final int damage = 100;
      final Hp hp = new Hp(maxHp);
      //when
      hp.decrease(damage);
      //then
      assertThat(hp.isDead())
          .isFalse();
    }
  }
}
