package bossmonster.view;

import static bossmonster.view.InputExceptionMessage.INPUT_IS_NOT_NUMERIC;
import static bossmonster.view.InputExceptionMessage.PLAYER_STATUS_INPUT_SIZE_IS_NOT_VALID;

import bossmonster.dto.PlayerStatusRequest;
import java.util.Scanner;

public class InputView {

  public static final String DELIMITER = ",";
  public static final int MAX_HP_INDEX = 0;
  public static final int MAX_MP_INDEX = 1;
  public static final int VALID_STATUS_INPUT_SIZE = 2;

  private final Scanner scanner = new Scanner(System.in);

  public int readBossHp() {
    final String input = scanner.nextLine().trim();
    try {
      return Integer.parseInt(input);
    } catch (final NumberFormatException exception) {
      throw new IllegalArgumentException(INPUT_IS_NOT_NUMERIC);
    }
  }

  public String readPlayerName() {
    return scanner.nextLine().trim();
  }

  public PlayerStatusRequest readPlayerHpAndMp() {
    final String input = scanner.nextLine().trim();
    final String[] splitInput = input.split(DELIMITER);

    if (splitInput.length != VALID_STATUS_INPUT_SIZE) {
      throw new IllegalArgumentException(PLAYER_STATUS_INPUT_SIZE_IS_NOT_VALID);
    }

    final int maxHp = Integer.parseInt(splitInput[MAX_HP_INDEX].trim());
    final int maxMp = Integer.parseInt(splitInput[MAX_MP_INDEX].trim());

    return new PlayerStatusRequest(maxHp, maxMp);
  }

  public int readAttackType() {
    final String input = scanner.nextLine().trim();
    try {
      return Integer.parseInt(input);
    } catch (final NumberFormatException exception) {
      throw new IllegalArgumentException(INPUT_IS_NOT_NUMERIC);
    }
  }
}
