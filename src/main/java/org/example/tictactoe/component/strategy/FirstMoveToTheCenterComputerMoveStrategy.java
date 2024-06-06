
package org.example.tictactoe.component.strategy;

import org.example.tictactoe.component.ComputerMoveStrategy;
import org.example.tictactoe.model.game.Cell;
import org.example.tictactoe.model.game.GameTable;
import org.example.tictactoe.model.game.Sign;

public class FirstMoveToTheCenterComputerMoveStrategy implements ComputerMoveStrategy {

    @Override
    public boolean tryToMakeMove(final GameTable gameTable, final Sign sign) {
        final Cell cell = new Cell(1, 1);
        if (gameTable.isEmpty(cell)) {
            gameTable.setSign(cell, sign);
            return true;
        } else {
            return false;
        }
    }
}
