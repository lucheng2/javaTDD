package com.ddd.chap03;

public class TicTacToe {

    private Character[][] board = {
            {'\0', '\0', '\0'},
            {'\0', '\0', '\0'},
            {'\0', '\0', '\0'}
    };
    private Character lastPlayer = '\0';
    final int SIZE = 3;

    public String play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        lastPlayer = nextPlayer();
        setBox(x, y, lastPlayer);
        if (isWin(x, y)) {
            return String.format("%c is winner", lastPlayer);
        }
        if (isDraw()) {
            return "the result is draw";
        }
        return "no winner";
    }

    public char nextPlayer() {
        if (lastPlayer == 'X') {
            return 'O';
        }
        return 'X';
    }

    private void checkAxis(int axis) {
        if (axis<1 || axis > 3) {
            throw new RuntimeException("axis is outside of boarder!");
        }
    }

    private void setBox(int x, int y, Character lastPlayer) {
        if(board[x-1][y-1] != '\0') {
            throw new RuntimeException("position is occupied!");
        }
        board[x-1][y-1] = lastPlayer;
    }

    boolean isWin(int x, int y) {
        int playerTotal = lastPlayer * 3;
        int vertical, horizontal, dialog1, dialog2;
        vertical = horizontal = dialog1 = dialog2 = '\0';
        for (int i=0; i<SIZE; i++) {
            vertical += board[i][y-1];
            horizontal += board[x-1][i];
            dialog1 += board[i][i];
            dialog2 += board[i][SIZE-1-i];
        }
        if (playerTotal == vertical || playerTotal == horizontal || playerTotal == dialog1 || playerTotal == dialog2) {
            return true;
        }
        return false;
    }

    boolean isDraw() {
        for (int i=0; i<SIZE; i++) {
            for (int j=0; j<SIZE; j++) {
                if (board[i][j] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }
}
