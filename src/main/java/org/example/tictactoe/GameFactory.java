

package org.example.tictactoe;

import org.example.tictactoe.component.CellVerifier;
import org.example.tictactoe.component.ComputerMove;
import org.example.tictactoe.component.DataPrinter;
import org.example.tictactoe.component.Game;
import org.example.tictactoe.component.GameOverHandler;
import org.example.tictactoe.component.UserInputReader;
import org.example.tictactoe.component.UserMove;
import org.example.tictactoe.component.WinnerVerifier;
import org.example.tictactoe.component.config.CommandLineArgumentParser;
import org.example.tictactoe.component.console.CellNumberConverter;
import org.example.tictactoe.component.console.ConsoleDataPrinter;
import org.example.tictactoe.component.console.ConsoleGameOverHandler;
import org.example.tictactoe.component.console.ConsoleUserInputReader;
import org.example.tictactoe.component.console.keypad.DesktopNumericKeypadCellNumberConverter;
import org.example.tictactoe.component.swing.GameWindow;
import org.example.tictactoe.model.config.Level;
import org.example.tictactoe.model.config.PlayerType;
import org.example.tictactoe.model.config.UserInterface;
import org.example.tictactoe.model.game.Player;

import static org.example.tictactoe.model.config.PlayerType.USER;
import static org.example.tictactoe.model.config.UserInterface.GUI;
import static org.example.tictactoe.model.game.Sign.O;
import static org.example.tictactoe.model.game.Sign.X;

public class GameFactory {

    private final PlayerType player1Type;

    private final PlayerType player2Type;

    private final UserInterface userInterface;

    private final Level level;

    public GameFactory(final String[] args) {
        final CommandLineArgumentParser.CommandLineArguments commandLineArguments =
                new CommandLineArgumentParser(args).parse();
        player1Type = commandLineArguments.getPlayer1Type();
        player2Type = commandLineArguments.getPlayer2Type();
        userInterface = commandLineArguments.getUserInterface();
        level = commandLineArguments.getLevel();
    }

    public Game create() {
        final DataPrinter dataPrinter;
        final UserInputReader userInputReader;
        final GameOverHandler gameOverHandler;
        if (userInterface == GUI) {
            final GameWindow gameWindow = new GameWindow();
            dataPrinter = gameWindow;
            userInputReader = gameWindow;
            gameOverHandler = gameWindow;
        } else {
            final CellNumberConverter cellNumberConverter = new DesktopNumericKeypadCellNumberConverter();
            dataPrinter = new ConsoleDataPrinter(cellNumberConverter);
            userInputReader = new ConsoleUserInputReader(cellNumberConverter, dataPrinter);
            gameOverHandler = new ConsoleGameOverHandler(dataPrinter);
        }
        final Player player1;
        if (player1Type == USER) {
            player1 = new Player(X, new UserMove(userInputReader, dataPrinter));
        } else {
            player1 = new Player(X, new ComputerMove(level.getStrategies()));
        }
        final Player player2;
        if (player2Type == USER) {
            player2 = new Player(O, new UserMove(userInputReader, dataPrinter));
        } else {
            player2 = new Player(O, new ComputerMove(level.getStrategies()));
        }
        final boolean canSecondPlayerMakeFirstMove = player1Type != player2Type;
        return new Game(
                dataPrinter,
                player1,
                player2,
                new WinnerVerifier(),
                new CellVerifier(),
                gameOverHandler,
                canSecondPlayerMakeFirstMove
        );
    }
}
