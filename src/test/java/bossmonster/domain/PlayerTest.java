package bossmonster.domain;

import static bossmonster.domain.AttackType.MAGIC_ATTACK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PlayerTest {

  private final PlayerName validPlayerName = new PlayerName("valid");

  @Nested
  class 플레이어_생성 {

    @Test
    void 정상적으로_생성된다() {
      //given
      final int validMaxHpValue = 100;
      final int validMaxMpValue = 50;

      //when
      final Player player = new Player(validPlayerName, validMaxHpValue, validMaxMpValue);

      //then
      assertAll(
          () -> assertThat(player.getRemainHp())
              .isEqualTo(validMaxHpValue),
          () -> assertThat(player.getRemainMp())
              .isEqualTo(validMaxMpValue),
          () -> assertThat(player.getName())
              .isEqualTo(validPlayerName.getValue())
      );
    }

    @Test
    void 체력과_마나의_합이_200초과면_예외가_발생한다() {
      //given
      final int validMaxHpValue = 100;
      final int validMaxMpValue = 101;

      //when
      assertThatThrownBy(
          () -> new Player(validPlayerName, validMaxHpValue, validMaxMpValue)
      ).isInstanceOf(IllegalArgumentException.class);
    }
  }

  @Test
  void 공격_타입에_따라_mp가_변화할_수_있다() {
    final int maxMp = 100;
    final int changeValue = MAGIC_ATTACK.getMpChangeValue();
    final Player player = new Player(new PlayerName("홍혁준"), 100, maxMp);

    player.changeMp(MAGIC_ATTACK);

    assertThat(player.getRemainMp())
        .isEqualTo(maxMp + changeValue);
  }
}