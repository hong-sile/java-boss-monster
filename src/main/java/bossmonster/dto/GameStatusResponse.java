package bossmonster.dto;

import bossmonster.domain.Boss;
import bossmonster.domain.Player;

public class GameStatusResponse {

  private final int maxBossHp;
  private final int bossHp;
  private final String userName;
  private final int maxPlayerHp;
  private final int playerHp;
  private final int maxPlayerMp;
  private final int playerMp;

  public GameStatusResponse(
      final int maxBossHp, final int bossHp, final String userName, final int maxPlayerHp,
      final int playerHp, final int maxPlayerMp, final int playerMp
  ) {
    this.maxBossHp = maxBossHp;
    this.bossHp = bossHp;
    this.userName = userName;
    this.maxPlayerHp = maxPlayerHp;
    this.playerHp = playerHp;
    this.maxPlayerMp = maxPlayerMp;
    this.playerMp = playerMp;
  }

  public static GameStatusResponse of(final Boss boss, final Player player) {
    return new GameStatusResponse(
        boss.getMaxHp(), boss.getRemainHp(), player.getName(), player.getMaxHp(),
        player.getRemainHp(), player.getMaxMp(), player.getRemainMp()
    );
  }
}
