package bossmonster.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PlayerNameTest {

  @Nested
  class 플레이어_이름_생성 {

    @Test
    void 정상적으로_생성된다() {
      //given
      final String validName = "valid";
      //when
      final PlayerName playerName = new PlayerName(validName);
      //then
      assertThat(playerName.getValue())
          .isEqualTo(validName);
    }

    @Test
    void 플레이어의_이름이_6이상이면_예외가_발생한다() {
      //given
      final String inValidName = "invalid";

      //when
      assertThatThrownBy(() -> new PlayerName(inValidName))
          .isInstanceOf(IllegalArgumentException.class);
    }
  }
}