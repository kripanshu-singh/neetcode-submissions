class Solution {
    public void sink(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';

        // UP
        sink(i + 1, j, grid);
        // DOWN
        sink(i - 1, j, grid);
        // RIGHT
        sink(i, j + 1, grid);
        // LEFT
        sink(i, j - 1, grid);
    }
    public int numIslands(char[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    sink(i, j, grid);
                    ans++;
                }
            }
                System.out.println();
        }
        return ans;
    }
}
