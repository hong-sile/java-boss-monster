package bossmonster.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BossTest {

  @Nested
  class 보스생성 {

    @Test
    void 정상적으로_생성된다() {
      //given
      final int validMaxHpValue = 100;
      //when
      final Boss boss = new Boss(validMaxHpValue);
      //then
      assertThat(boss.getHpValue())
          .isEqualTo(validMaxHpValue);
    }

    @Test
    void 체력이_100미만인경우_예외가_발생한다() {
      //given
      final int inValidMaxHpValue = 99;

      //when
      assertThatThrownBy(() -> new Boss(inValidMaxHpValue))
          .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 체력이_300을_넘는_경우_예외가_발생한다() {
      //given
      final int inValidMaxHpValue = 301;

      //when
      assertThatThrownBy(() -> new Boss(inValidMaxHpValue))
          .isInstanceOf(IllegalArgumentException.class);
    }
  }
}