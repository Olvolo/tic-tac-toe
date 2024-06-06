

package org.example.tictactoe;

import org.example.tictactoe.component.Game;


public final class Launcher {

    public static void main(final String[] args) {
        final GameFactory gameFactory = new GameFactory(args);
        final Game game = gameFactory.create();
        game.play();
    }
}
