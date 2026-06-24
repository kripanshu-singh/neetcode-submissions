class Solution {
    public boolean solve(int i, int j, int ind, String word, char[][] board, boolean[][] visit) {
        if (ind == word.length())
            return true;

        if (i < 0 || i == board.length || j < 0 || j == board[0].length
            || word.charAt(ind) != board[i][j] || visit[i][j]) {
            return false;
        }
        visit[i][j] = true;
        // UP
        boolean up = solve(i + 1, j, ind + 1, word, board, visit);
        // DOWN
        boolean down = solve(i - 1, j, ind + 1, word, board, visit);
        // LEFT
        boolean left = solve(i, j - 1, ind + 1, word, board, visit);
        // RIGHT
        boolean right = solve(i, j + 1, ind + 1, word, board, visit);
        
        visit[i][j] = false;

        return up || down || left || right;
    }
    public boolean exist(char[][] board, String word) {
        char target = word.charAt(0);
        List<int[]> targetInd = new ArrayList<>();
        int n = board.length;
        int m = board[0].length;
        boolean[][] visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == target) {
                    targetInd.add(new int[] {i, j});
                }
            }
        }

        for (int[] arr : targetInd) {
            if (solve(arr[0], arr[1], 0, word, board, visit)) {
                return true;
            }
        }
        return false;
    }
}
