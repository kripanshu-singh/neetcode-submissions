class Solution {
    public int findArea(int i, int j, int[][] grid) {
        if  (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
            return 0;

        grid[i][j] = 0;

        int UP = findArea(i + 1, j, grid);
        int LEFT = findArea(i, j + 1, grid);
        int DOWN = findArea(i - 1, j, grid);
        int RIGHT = findArea(i, j - 1, grid);

        return UP + DOWN + LEFT + RIGHT + 1;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    ans = Math.max(findArea(i, j, grid), ans);
            }
        }
        return ans;
    }
}
