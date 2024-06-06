

package org.example.tictactoe.component;

import org.example.tictactoe.model.game.Cell;
import org.example.tictactoe.model.game.GameTable;


public class CellVerifier {

    public boolean allCellsFilled(final GameTable gameTable) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameTable.isEmpty(new Cell(i, j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
