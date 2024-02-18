package bossmonster.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RoundTest {

  @Test
  void 라운드를_하나_진행시킨다() {
    final Round round = new Round();

    round.playRound();

    assertThat(round.getValue())
        .isEqualTo(1);
  }
}