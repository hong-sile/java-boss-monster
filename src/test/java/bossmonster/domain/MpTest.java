package bossmonster.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MpTest {

  @Test
  void 최대마나가_0이하인_경우_예외처리한다() {
    assertThatThrownBy(() -> new Mp(-1))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Nested
  class mp가_변화할_수_있다 {

    @Test
    void 변화후_mp가_0_미만이면_예외처리가_발생한다() {
      final Mp mp = new Mp(0);

      assertThatThrownBy(() -> mp.change(-1))
          .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 변화후_mp의_최대값은_max랑_동일하다() {
      final Mp mp = new Mp(100);

      mp.change(100);

      assertThat(mp.getRemain())
          .isEqualTo(mp.getMax());
    }
  }
}
