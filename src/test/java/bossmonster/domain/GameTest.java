package bossmonster.domain;

import static bossmonster.domain.AttackType.MAGIC_ATTACK;
import static bossmonster.domain.AttackType.PHYSICAL_ATTACK;
import static bossmonster.fixture.BossFixture.hp200인_보스;
import static bossmonster.fixture.PlayerFixture.hp100_mp100인_플레이어;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import bossmonster.fake.DefineBossDamageGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GameTest {

  public static final int GENERATED_NUMBER = 20;
  private final BossDamageGenerator bossDamageGenerator = new DefineBossDamageGenerator(
      GENERATED_NUMBER);
  private Game game;

  @BeforeEach
  void setUp() {
    game = new Game(hp100_mp100인_플레이어(), hp200인_보스(), bossDamageGenerator);
  }

  @Nested
  class 보스는_데미지를_입고_플레이어는_마나가_변화한다 {

    @Test
    void 물리공격이면_보스_체력이_10이_감소하고_플레이어마나가_10증가한다() {
      game.attackBoss(PHYSICAL_ATTACK);

      assertAll(
          () -> assertThat(game.getPlayer().getRemainMp())
              .isEqualTo(100),
          () -> assertThat(game.getBoss().getRemainHp())
              .isEqualTo(190)
      );
    }

    @Test
    void 마법공격이면_보스_체력이_20이_감소하고_플레이어마나가_30감소한다() {
      game.attackBoss(MAGIC_ATTACK);

      assertAll(
          () -> assertThat(game.getPlayer().getRemainMp())
              .isEqualTo(70),
          () -> assertThat(game.getBoss().getRemainHp())
              .isEqualTo(180)
      );
    }
  }

  @Test
  void 보스가_공격하면_플레이어는_데미지를_입는다() {
    game.attackPlayer();

    assertThat(game.getPlayer().getRemainHp())
        .isEqualTo(80);
  }
}