package bossmonster.controller;

import static bossmonster.domain.GameResult.PLAYER_LOSE;
import static bossmonster.domain.GameResult.PLAYER_WIN;

import bossmonster.domain.AttackType;
import bossmonster.domain.Boss;
import bossmonster.domain.Game;
import bossmonster.domain.GameResult;
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
    final GameResult gameResult = playGame(game);
    printResult(gameResult, game);
  }

  private void printResult(final GameResult gameResult, final Game game) {
    if (gameResult == PLAYER_LOSE) {
      final GameStatusResponse gameStatusResponse =
          GameStatusResponse.of(game.getBoss(), game.getPlayer());
      outputView.printPlayerLoseMessage(gameStatusResponse);
    }
    if (gameResult == PLAYER_WIN) {
      outputView.printPlayerWinMessage(round.getValue(), game.getPlayer().getName());
    }
  }

  private GameResult playGame(final Game game) {
    playerTurn(game);
    if (game.isBossDead()) {
      return PLAYER_WIN;
    }

    bossTurn(game);
    if (game.isPlayerDead()) {
      return PLAYER_LOSE;
    }

    printGameProgress(game);
    round.playRound();
    return playGame(game);
  }

  private void bossTurn(final Game game) {
    final int damage = game.attackPlayer();
    outputView.printBossAttackMessage(damage);
  }

  private void playerTurn(final Game game) {
    final AttackType attackType
        = repeatUntilValid(AttackType::from, inputView::readAttackType);
    final int damage = game.attackBoss(attackType);
    outputView.printPlayerAttackMessage(attackType.getType(), damage);
  }

  private void printGameProgress(final Game game) {
    final GameStatusResponse status = GameStatusResponse.of(game.getBoss(), game.getPlayer());
    outputView.printGameProgressMessage(status);
  }

  private Game initGame() {
    final Boss boss = repeatUntilValid(Boss::new, inputView::readBossHp);

    final PlayerName name = repeatUntilValid(PlayerName::new, inputView::readPlayerName);

    final Player player = repeatUntilValid(
        request -> new Player(name, request.maxHp(), request.maxMp()),
        inputView::readPlayerHpAndMp
    );

    final GameStatusResponse statusResponse = GameStatusResponse.of(boss, player);
    outputView.printInitGameMessage(statusResponse);

    return new Game(player, boss, new RandomBossDamageGenerator());
  }

  private <T, R> R repeatUntilValid(
      final Function<T, R> function, final Supplier<T> reader
  ) {
    try {
      return function.apply(reader.get());
    } catch (final IllegalArgumentException exception) {
      outputView.printExceptionMessage(exception);
      return repeatUntilValid(function, reader);
    }
  }
}
