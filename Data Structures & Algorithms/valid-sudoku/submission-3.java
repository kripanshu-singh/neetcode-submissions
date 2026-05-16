class Solution {
    public boolean checkRow(char num, int row, int col, char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (i == col)
                continue;
            if (board[row][i] == num)
                return false;
        }
        return true;
    }
    public boolean checkCol(char num, int row, int col, char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (i == row)
                continue;
            if (board[i][col] == num)
                return false;
        }
        return true;
    }
    public boolean checkGrid(char num, int row, int col, char[][] board) {
        int rowLower = (row / 3) * 3;
        int rowUpper = rowLower + 3;

        int colLower = (col / 3) * 3;
        int colUpper = colLower + 3;
        for (int i = rowLower; i < rowUpper; i++) {
            for (int j = colLower; j < colUpper; j++) {
                if (i == row && j == col)
                    continue;
                if (board[i][j] == num)
                    return false;
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (board[i][j] != '.'
                    && (!checkRow(num, i, j, board) || !checkCol(num, i, j, board)
                        || !checkGrid(num, i, j, board))) {
                    return false;
                }
            }
        }
        return true;
    }
}