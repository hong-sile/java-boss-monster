package bossmonster.view;

import static java.lang.System.lineSeparator;

import bossmonster.dto.GameStatusResponse;

public class OutputView {

  private static final OutputView INSTANCE = new OutputView();
  private static final String ERROR_MESSAGE_FORMAT = "[ERROR] ";
  private static final String DOUBLE_LINE = "============================";
  private static final String SINGLE_LINE = "____________________________";
  private static final String READ_BOSS_HP_MESSAGE = "보스 몬스터의 HP를 입력해주세요.";
  private static final String READ_PLAYER_NAME_MESSAGE = "플레이어의 이름을 입력해주세요";
  private static final String READ_PLAYER_HP_AND_MP_MESSAGE = "플레이어의 HP와 MP를 입력해주세요.(,로 구분)";
  private static final String READ_ATTACK_TYPE_MESSAGE
      = "어떤 공격을 하시겠습니까?" + lineSeparator() +
      "1. 물리 공격" + lineSeparator() +
      "2. 마법 공격";
  private static final String INIT_GAME_MESSAGE = "보스 레이드를 시작합니다!" + lineSeparator();
  private static final String BOSS_HP_FORMAT = "BOSS HP [%d/%d]";
  private static final String USER_STATUS_FORMAT = "%s HP [%d/%d] MP [%d/%d]";
  private static final String BOSS_WIN_MESSAGE_FORMAT
      = "%s의 HP가 0이 되었습니다." + lineSeparator() +
      "보스 레이드에 실패했습니다.";
  private static final int PHYSICAL_ATTACK_TYPE = 1;
  private static final String PHYSICAL_ATTACK_MESSAGE = "물리 공격을 했습니다.";
  private static final int MAGIC_ATTACK_TYPE = 2;
  private static final String MAGIC_ATTACK_MESSAGE = "마법 공격을 했습니다.";
  private static final String DAMAGE_FORMAT = " (입힌 데미지: %d)";
  private static final String BOSS_ATTACK_MESSAGE = "보스가 공격 했습니다.";
  private static final String GAME_END_MESSAGE_FORMAT =
      lineSeparator() + "%s 님이 %d번의 전투 끝에 보스 몬스터를 잡았습니다.";

  private OutputView() {
  }

  public static OutputView getInstance() {
    return INSTANCE;
  }

  public void printExceptionMessage(final IllegalArgumentException exception) {
    System.out.println(ERROR_MESSAGE_FORMAT + exception.getMessage());
  }

  public void printReadBossHpMessage() {
    System.out.println(READ_BOSS_HP_MESSAGE);
  }

  public void printReadPlayerName() {
    System.out.println(READ_PLAYER_NAME_MESSAGE);
  }

  public void printReadPlayerHpAndMp() {
    System.out.println(READ_PLAYER_HP_AND_MP_MESSAGE);
  }

  public void printReadAttackType() {
    System.out.println(READ_ATTACK_TYPE_MESSAGE);
  }

  public void printInitGameMessage(final GameStatusResponse statusResponse) {
    System.out.println(INIT_GAME_MESSAGE);
    printBossImage(statusResponse, BossImage.START_BOSS_IMAGE);
  }

  public void printPlayerLoseMessage(final GameStatusResponse statusResponse) {
    printBossImage(statusResponse, BossImage.WINNING_BOSS_IMAGE);
    System.out.println(String.format(BOSS_WIN_MESSAGE_FORMAT, statusResponse.getUserName()));
  }

  public void printGameProgressMessage(final GameStatusResponse statusResponse) {
    printBossImage(statusResponse, BossImage.DAMAGED_BOSS_IMAGE);
  }

  public void printPlayerAttackMessage(final int attackType, final int damage) {
    if (PHYSICAL_ATTACK_TYPE == attackType) {
      System.out.println(String.format(PHYSICAL_ATTACK_MESSAGE + DAMAGE_FORMAT, damage));
    }
    if (MAGIC_ATTACK_TYPE == attackType) {
      System.out.println(String.format(MAGIC_ATTACK_MESSAGE + DAMAGE_FORMAT, damage));
    }
  }

  public void printBossAttackMessage(final int damage) {
    System.out.println(String.format(BOSS_ATTACK_MESSAGE + DAMAGE_FORMAT, damage));
  }

  public void printPlayerWinMessage(final int round, final String userName) {
    System.out.println(String.format(GAME_END_MESSAGE_FORMAT, userName, round));
  }

  private void printBossImage(final GameStatusResponse statusResponse, final String bossImage) {
    System.out.println(DOUBLE_LINE);
    System.out.println(
        String.format(BOSS_HP_FORMAT, statusResponse.getBossHp(), statusResponse.getMaxBossHp())
    );
    System.out.println(SINGLE_LINE);
    System.out.println(bossImage);
    System.out.println(SINGLE_LINE + lineSeparator());
    System.out.println(
        String.format(USER_STATUS_FORMAT,
            statusResponse.getUserName(),
            statusResponse.getPlayerHp(),
            statusResponse.getMaxPlayerHp(),
            statusResponse.getPlayerMp(),
            statusResponse.getMaxPlayerMp()
        )
    );
    System.out.println(DOUBLE_LINE);
  }
}
