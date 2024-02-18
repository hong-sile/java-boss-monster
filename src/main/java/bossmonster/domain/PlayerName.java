package bossmonster.domain;

public class PlayerName {

  private static final int VALIDATE_NAME_LENGTH = 5;

  private final String value;

  public PlayerName(final String value) {
    validateNameLength(value);
    this.value = value;
  }

  private void validateNameLength(final String value) {
    if (value.length() > VALIDATE_NAME_LENGTH) {
      throw new IllegalArgumentException("플레이어 이름은 5자 이하만 가능합니다.");
    }
  }

  public String getValue() {
    return value;
  }
}
