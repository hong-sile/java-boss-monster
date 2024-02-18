package bossmonster;

import bossmonster.controller.GameController;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

public class Main {

  public static void main(String[] args) {
    final GameController controller = new GameController(new InputView(), OutputView.getInstance());
    controller.run();
  }
}
