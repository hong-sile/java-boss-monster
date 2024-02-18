package bossmonster.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AttackTypeTest {

  @Nested
  class 숫자로_AttackType을_생성한다 {

    @Test
    void 정상적으로_생성한다() {
      //given
      final int physicalAttackTypeValue = 1;

      //when
      final AttackType attackType = AttackType.from(physicalAttackTypeValue);

      //then
      assertThat(attackType)
          .isEqualTo(AttackType.PHYSICAL_ATTACK);
    }

    @Test
    void 정해진값이_아닌_경우_예외처리한다() {
      final int invalidTypeValue = 3;

      assertThatThrownBy(() -> AttackType.from(invalidTypeValue))
          .isInstanceOf(IllegalArgumentException.class);
    }
  }
}