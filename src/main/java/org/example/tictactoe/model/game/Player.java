

package org.example.tictactoe.model.game;

import org.example.tictactoe.component.Move;

public final class Player {

    private final org.example.tictactoe.model.game.Sign sign;

    private final Move move;

    public Player(final org.example.tictactoe.model.game.Sign sign,
                  final Move move) {
        this.sign = sign;
        this.move = move;
    }

    public org.example.tictactoe.model.game.Sign getSign() {
        return sign;
    }

    public void makeMove(final GameTable gameTable) {
        move.make(gameTable, sign);
    }

    @Override
    public String toString() {
        return "'" + sign + "'";
    }
}
