class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visit = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O') {
                q.add(new int[] {0, i});
                visit[0][i] = true;
            }
            if (board[n - 1][i] == 'O') {
                q.add(new int[] {n - 1, i});
                visit[n - 1][i] = true;
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (board[i][0] == 'O') {
                q.add(new int[] {i,0});
                visit[i][0] = true;
            }
            if (board[i][m - 1] == 'O') {
                q.add(new int[] {i, m - 1});
                visit[i][m - 1] = true;
            }
        }
        int[][] direc = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int[] indexes = q.poll();

            for (int[] dir : direc) {
                int x = indexes[0] + dir[0];
                int y = indexes[1] + dir[1];

                if (x < 0 || y < 0 || x >= n || y >= m || visit[x][y] || board[x][y]!='O')
                    continue;

                visit[x][y] = true;
                q.offer(new int[]{x,y});
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(!visit[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
