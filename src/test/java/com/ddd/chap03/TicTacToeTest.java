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

    @Test
    public void whenPlayThenNoWinner() {
        String actual = ticTacToe.play(1, 2);
        Assertions.assertEquals("no winner", actual);
    }

    @Test
    public void whenPlayWholeHorizontalLineThenWinner() {
        ticTacToe.play(1, 1); // X
        ticTacToe.play(2, 1); // O
        ticTacToe.play(1, 2); // X
        ticTacToe.play(2, 2); // O
        String actual = ticTacToe.play(1, 3);// X
        assertEquals("X is winner", actual);
    }


    @Test
    public void whenPlayWholeVerticalLineThenWinner() {
        ticTacToe.play(1, 1); // X
        ticTacToe.play(1, 2); // O
        ticTacToe.play(2, 1); // X
        ticTacToe.play(1, 3); // O
        String actual = ticTacToe.play(3, 1);// X
        Assertions.assertEquals("X is winner", actual);
    }

    @Test
    public void whenPlayTop2BottomDialogLineThenWinner() {
        ticTacToe.play(1, 1);
        ticTacToe.play(1, 2);
        ticTacToe.play(2, 2);
        ticTacToe.play(2, 1);
        String actual = ticTacToe.play(3, 3);
        Assertions.assertEquals("X is winner", actual);
    }

    @Test
    public void whenPlayBottom2TopDialogLineThenWinner() {
        ticTacToe.play(1, 3);
        ticTacToe.play(1, 2);
        ticTacToe.play(2, 2);
        ticTacToe.play(2, 1);
        String play = ticTacToe.play(3, 1);
        Assertions.assertEquals("X is winner", play);
    }

    @Test
    public void whenAllBoxesFilledThenDraw() {
        ticTacToe.play(1, 1);
        ticTacToe.play(1, 2);
        ticTacToe.play(1, 3);
        ticTacToe.play(2, 1);
        ticTacToe.play(2, 3);
        ticTacToe.play(2, 2);
        ticTacToe.play(3, 1);
        ticTacToe.play(3, 3);
        String play = ticTacToe.play(3, 2);
        Assertions.assertEquals("the result is draw", play);
    }
}