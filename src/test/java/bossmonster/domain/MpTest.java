package bossmonster.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class MpTest {

  @Test
  void 최대마나가_0이하인_경우_예외처리한다() {
    assertThatThrownBy(() -> new Hp(0))
        .isInstanceOf(IllegalArgumentException.class);
  }
}