
package org.example.tictactoe.component.console.keypad;

import org.example.tictactoe.component.console.CellNumberConverter;
import org.example.tictactoe.model.game.Cell;

import static java.lang.String.format;


public class TerminalNumericKeypadCellNumberConverter implements CellNumberConverter {

    @Override
    public Cell toCell(final char number) {
        if (number >= '1' && number <= '9') {
            final int val = number - '0' - 1;
            return new Cell(val / 3, val % 3);
        } else {
            throw new IllegalArgumentException(
                    format("Number parameter must be between '1' and '9'! Current value is '%s'!", number)
            );
        }
    }

    @Override
    public char toNumber(final Cell cell) {
        if (cell.getRow() >= 0 && cell.getRow() <= 2 && cell.getCol() >= 0 && cell.getCol() <= 2) {
            return (char) ('0' + (cell.getRow() * 3 + cell.getCol() + 1));
        } else {
            throw new IllegalArgumentException(
                    format(
                            "Row and col indexes must be between 0 and 2! Current row is %s, current col is %s!",
                            cell.getRow(), cell.getCol()
                    )
            );
        }
    }
}
