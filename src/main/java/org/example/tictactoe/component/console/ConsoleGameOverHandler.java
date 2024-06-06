

package org.example.tictactoe.component.console;

import org.example.tictactoe.component.DataPrinter;
import org.example.tictactoe.component.GameOverHandler;

import java.util.Scanner;

public class ConsoleGameOverHandler implements GameOverHandler {

    private final DataPrinter dataPrinter;

    public ConsoleGameOverHandler(final DataPrinter dataPrinter) {
        this.dataPrinter = dataPrinter;
    }

    @Override
    public void gameOver() {
        dataPrinter.printInfoMessage("GAME OVER!");
        new Scanner(System.in).nextLine();
    }
}
