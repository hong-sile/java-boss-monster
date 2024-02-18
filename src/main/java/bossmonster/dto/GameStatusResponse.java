package bossmonster.dto;

public record GameStatusResponse(
    int maxBossHp,
    int bossHp,
    String userName,
    int maxPlayerHp,
    int playerHp,
    int maxPlayerMp,
    int playerMp
) {

}
