class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        int ans = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            boolean rottedAny = false;
            for (int l = 0; l < qSize; l++) {
                int[] coordinates = q.poll();
                int x = coordinates[0];
                int y = coordinates[1];

                int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

                for (int[] move : moves) {
                    int newX = x + move[0];
                    int newY = y + move[1];

                    if (newX < 0 || newY < 0 || newX >= n || newY >= m || grid[newX][newY] != 1)
                        continue;

                    grid[newX][newY] = 2;
                    rottedAny = true;
                    q.offer(new int[] {newX, newY});
                }
            }
            if (rottedAny)
                ans++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }
}
