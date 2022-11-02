package com.ddd.chap03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    private TicTacToe ticTacToe;

    @BeforeEach
    void setUp() {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void whenXOutsideBoarderThenRuntimeException() {
        Assertions.assertThrows(RuntimeException.class, ()-> {ticTacToe.play(5, 3);});
    }

    @Test
    public void whenYOutsideBoarderThenRuntimeException() {
        Assertions.assertThrows(RuntimeException.class, () -> {ticTacToe.play(2, 5);});
    }

    @Test
    public void whenOccupiedThenRuntimeException() {
        Assertions.assertThrows(RuntimeException.class, () -> {ticTacToe.play(2, 1); ticTacToe.play(2, 1);});
    }

    @Test
    public void givenFirstTurnWhenNextPlayerThenX() {
        Assertions.assertEquals('X', ticTacToe.nextPlayer());
    }

    @Test
    public void givenLastTurnWhenNextPlayerThenO() {
        ticTacToe.play(1,2);
        Assertions.assertEquals('O', ticTacToe.nextPlayer());
    }
}