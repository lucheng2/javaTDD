package com.ddd.chap03;

public class TicTacToe {

    private Character[][] board = {
            {'\0', '\0', '\0'},
            {'\0', '\0', '\0'},
            {'\0', '\0', '\0'}
    };
    private Character nextPlayer = '\0';

    public void play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        setBox(x, y);
        nextPlayer = nextPlayer();
    }

    public char nextPlayer() {
        if (nextPlayer == 'X') {
            return 'O';
        }
        return 'X';
    }

    private void checkAxis(int axis) {
        if (axis<1 || axis > 3) {
            throw new RuntimeException("axis is outside of boarder!");
        }
    }

    private void setBox(int x, int y) {
        if(board[x-1][y-1] != '\0') {
            throw new RuntimeException("position is occupied!");
        }
        board[x-1][y-1] = 'X';
    }
}
