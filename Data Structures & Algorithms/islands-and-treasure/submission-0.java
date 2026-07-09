class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0)
                    q.offer(new int[] {i, j});
            }
        }

        int step = 1;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int[] indexes = q.poll();
                int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                for (int[] move : moves) {
                    int x = indexes[0] + move[0];
                    int y = indexes[1] + move[1];

                    if (x < 0 || y < 0 || x >= n || y >= m || grid[x][y] != Integer.MAX_VALUE)
                        continue;
                    grid[x][y] = step;
                    q.offer(new int[] {x, y});
                }
            }
            step++;
        }
    }
}