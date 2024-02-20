package bossmonster.fixture;

import bossmonster.domain.Player;
import bossmonster.domain.PlayerName;

public class PlayerFixture {

  public static Player hp100_mp100인_플레이어() {
    final PlayerName playerName = new PlayerName("혁준");
    return new Player(playerName, 100, 100);
  }
}
