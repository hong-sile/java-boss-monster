package bossmonster.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CharacterTest {

  @Nested
  class 죽었는지_확인할_수_있다 {

    @Test
    void hp가_다_소모된_경우_참을_반환한다() {
      //given
      final Character character = new Boss(200);
      character.damaged(300);

      //when
      final boolean isDead = character.isDead();
      //then
      assertThat(isDead)
          .isTrue();
    }

    @Test
    void hp가_다_소모되지_않은_경우_거짓을_반환한다() {
      //given
      final Character character = new Boss(200);
      //when
      final boolean isDead = character.isDead();
      //then
      assertThat(isDead)
          .isFalse();
    }
  }

  @Test
  void 데미지를_입는다() {
    //given
    final int maxHpValue = 200;
    final int damage = 50;
    final Character character = new Boss(maxHpValue);
    //when
    character.damaged(damage);
    //then
    assertThat(character.getRemainHp())
        .isEqualTo(maxHpValue - damage);
  }
}