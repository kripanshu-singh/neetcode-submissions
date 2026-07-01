class Solution {
    List<List<String>> ans = new ArrayList<>();
    public boolean check(int row, int col, char[][] board) {
        int n = board.length;
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        int i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }
    public void solve(int row, int n, char[][] board) {
        if (row == n) {
            ans.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (check(row, col, board)) {
                board[row][col] = 'Q';
                solve(row + 1, n, board);
                board[row][col] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        int k = n;
        solve(0, n, board);
        return ans;
    }
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}
