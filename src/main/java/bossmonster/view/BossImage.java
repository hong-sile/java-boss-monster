package bossmonster.view;

import static java.lang.System.lineSeparator;

public class BossImage {

  public static final String START_BOSS_IMAGE
      = "   ^-^" + lineSeparator() +
      " / 0 0 \\" + lineSeparator() +
      "(   \"   )" + lineSeparator() +
      " \\  -  /" + lineSeparator() +
      "  - ^ -";
  public static final String DAMAGED_BOSS_IMAGE
      = "   ^-^" + lineSeparator() +
      " / x x \\" + lineSeparator() +
      "(   \"\\  )" + lineSeparator() +
      "\\  ^  /" + lineSeparator() +
      "  - ^ -";
  ;
  public static final String WINNING_BOSS_IMAGE
      = "   ^-^" + lineSeparator() +
      " / ^ ^ \\" + lineSeparator() +
      "(   \"   )" + lineSeparator() +
      " \\  3  /" + lineSeparator() +
      "  - ^ -";

  private BossImage() {
  }
}
