package bossmonster.controller;

import static bossmonster.domain.GameStatus.PLAYER_LOSE;
import static bossmonster.domain.GameStatus.PLAYER_WIN;

import bossmonster.domain.AttackType;
import bossmonster.domain.Boss;
import bossmonster.domain.Game;
import bossmonster.domain.GameStatus;
import bossmonster.domain.Player;
import bossmonster.domain.PlayerName;
import bossmonster.domain.RandomBossDamageGenerator;
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
    final GameStatus gameStatus = playGame(game);
    printResult(gameStatus);
  }

  private void printResult(final GameStatus gameStatus) {

  }

  private GameStatus playGame(final Game game) {
    playerTurn(game);
    if (game.isBossDead()) {
      return PLAYER_WIN;
    }

    game.attackPlayer();
    if (game.isPlayerDead()) {
      return PLAYER_LOSE;
    }

    printGameProgress();
    round.playRound();
    return playGame(game);
  }

  private void playerTurn(final Game game) {
    final AttackType attackType
        = repeatUntilInitialValid(AttackType::from, inputView::readAttackType);

    game.attackBoss(attackType);
  }

  private void printGameProgress() {

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

    return new Game(player, boss, new RandomBossDamageGenerator());
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
