

package org.example.tictactoe.component;

import org.example.tictactoe.model.game.GameTable;
import org.example.tictactoe.model.game.Sign;


public interface ComputerMoveStrategy {

    boolean tryToMakeMove(GameTable gameTable, Sign sign);
}
