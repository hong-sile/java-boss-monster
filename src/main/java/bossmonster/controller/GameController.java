package bossmonster.controller;

import bossmonster.domain.Boss;
import bossmonster.domain.Game;
import bossmonster.domain.Player;
import bossmonster.domain.PlayerName;
import bossmonster.domain.Round;
import bossmonster.dto.GameStatusResponse;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;
import java.util.function.Function;
import java.util.function.Supplier;

public class GameController {

  private final InputView inputView;
  private final OutputView outputView;
  private final Round round = new Round();

  public GameController(final InputView inputView, final OutputView outputView) {
    this.inputView = inputView;
    this.outputView = outputView;
  }

  public void run() {
    final Game game = initGame();
    startGame(game);
  }

  private void startGame(final Game game) {

    round.playRound();
  }

  private Game initGame() {
    final Boss boss = repeatUntilInitialValid(Boss::new, inputView::readBossHp);

    final PlayerName name = repeatUntilInitialValid(PlayerName::new, inputView::readPlayerName);

    final Player player = repeatUntilInitialValid(
        request -> new Player(name, request.maxHp(), request.maxMp()),
        inputView::readPlayerHpAndMp
    );

    final GameStatusResponse statusResponse = GameStatusResponse.of(boss, player);
    outputView.printInitGameMessage(statusResponse);

    return new Game(player, boss);
  }

  private <T, R> R repeatUntilInitialValid(
      final Function<T, R> function, final Supplier<T> reader
  ) {
    try {
      return function.apply(reader.get());
    } catch (final IllegalArgumentException exception) {
      outputView.printExceptionMessage(exception);
      return repeatUntilInitialValid(function, reader);
    }
  }
}
