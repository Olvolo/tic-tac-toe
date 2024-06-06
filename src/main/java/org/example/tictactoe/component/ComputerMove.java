

package org.example.tictactoe.component;

import org.example.tictactoe.model.game.GameTable;
import org.example.tictactoe.model.game.Sign;

public class ComputerMove implements org.example.tictactoe.component.Move {

    private final org.example.tictactoe.component.ComputerMoveStrategy[] strategies;

    public ComputerMove(final org.example.tictactoe.component.ComputerMoveStrategy[] strategies) {
        this.strategies = strategies;
    }

    @Override
    public void make(final GameTable gameTable, final Sign sign) {
        for (final org.example.tictactoe.component.ComputerMoveStrategy strategy : strategies) {
            if (strategy.tryToMakeMove(gameTable, sign)) {
                return;
            }
        }
        throw new IllegalArgumentException(
                "Game table does not contain empty cells or invalid configuration for the computer move strategies!"
        );
    }
}
