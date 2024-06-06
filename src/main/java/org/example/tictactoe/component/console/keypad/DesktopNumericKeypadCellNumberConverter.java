
package org.example.tictactoe.component.console.keypad;

import org.example.tictactoe.component.console.CellNumberConverter;
import org.example.tictactoe.model.game.Cell;

import static java.lang.String.format;


public class DesktopNumericKeypadCellNumberConverter implements CellNumberConverter {

    private final char[][] mapping = {
            {'7', '8', '9'},
            {'4', '5', '6'},
            {'1', '2', '3'}
    };

    @Override
    public Cell toCell(final char number) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (mapping[i][j] == number) {
                    return new Cell(i, j);
                }
            }
        }
        throw new IllegalArgumentException(
                format("Number parameter must be between '1' and '9'! Current value is '%s'!", number)
        );
    }

    @Override
    public char toNumber(final Cell cell) {
        try {
            return mapping[cell.getRow()][cell.getCol()];
        } catch (final ArrayIndexOutOfBoundsException ignore) {
            throw new IllegalArgumentException(
                    format(
                            "Row and col indexes must be between 0 and 2! Current row is %s, current col is %s!",
                            cell.getRow(), cell.getCol()
                    )
            );
        }
    }
}
