package bossmonster.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PlayerTest {

  private final PlayerName validPlayerName = new PlayerName("valid");

  @Nested
  class 플레이어_생성 {

    @Test
    void 정상적으로_생성된다() {
      //given
      final Hp validMaxHpValue = new Hp(100);
      final Mp validMaxMpValue = new Mp(50);

      //when
      final Player player = new Player(validPlayerName, validMaxHpValue, validMaxMpValue);

      //then
      assertAll(
          () -> Assertions.assertThat(player.getHpValue())
              .isEqualTo(100),
          () -> Assertions.assertThat(player.getMpValue())
              .isEqualTo(50),
          () -> Assertions.assertThat(player.getNameValue())
              .isEqualTo(validPlayerName.getValue())
      );
    }

    @Test
    void 체력과_마나의_합이_200초과면_예외가_발생한다() {
      //given
      final Hp validMaxHpValue = new Hp(100);
      final Mp validMaxMpValue = new Mp(101);

      //when
      assertThatThrownBy(
          () -> new Player(validPlayerName, validMaxHpValue, validMaxMpValue)
      ).isInstanceOf(IllegalArgumentException.class);
    }
  }
}