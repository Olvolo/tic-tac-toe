

package org.example.tictactoe.component.console;

import org.example.tictactoe.model.game.Cell;


public interface CellNumberConverter {

    Cell toCell(char number);

    char toNumber(Cell cell);
}
