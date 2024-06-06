

package org.example.tictactoe.model.config;

import org.example.tictactoe.component.ComputerMoveStrategy;
import org.example.tictactoe.component.strategy.FirstMoveToTheCenterComputerMoveStrategy;
import org.example.tictactoe.component.strategy.PreventUserWinComputerMoveStrategy;
import org.example.tictactoe.component.strategy.RandomComputerMoveStrategy;
import org.example.tictactoe.component.strategy.WinNowComputerMoveStrategy;
import org.example.tictactoe.component.strategy.WinOnTheNextStepComputerMoveStrategy;


public enum Level {

    LEVEL1(new ComputerMoveStrategy[]{
            new FirstMoveToTheCenterComputerMoveStrategy(),
            new RandomComputerMoveStrategy()
    }),

    LEVEL2(new ComputerMoveStrategy[]{
            new WinNowComputerMoveStrategy(),
            new PreventUserWinComputerMoveStrategy(),
            new FirstMoveToTheCenterComputerMoveStrategy(),
            new RandomComputerMoveStrategy()
    }),

    LEVEL3(new ComputerMoveStrategy[]{
            new WinNowComputerMoveStrategy(),
            new PreventUserWinComputerMoveStrategy(),
            new WinOnTheNextStepComputerMoveStrategy(),
            new FirstMoveToTheCenterComputerMoveStrategy(),
            new RandomComputerMoveStrategy()
    });

    private final ComputerMoveStrategy[] strategies;

    Level(final ComputerMoveStrategy[] strategies) {
        this.strategies = strategies;
    }

    public ComputerMoveStrategy[] getStrategies() {
        return strategies.clone();
    }
}
