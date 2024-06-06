

package org.example.tictactoe.component;

import org.example.tictactoe.model.game.GameTable;
import org.example.tictactoe.model.game.Sign;


public interface Move {

    void make(GameTable gameTable, Sign sign);
}
