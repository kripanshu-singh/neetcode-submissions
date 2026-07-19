class Solution {
    public boolean dfs(int i, List<List<Integer>> adj, boolean[] visit, boolean[] path) {
        if (path[i] && visit[i]) {
            return true;
        }
        if (visit[i]) {
            return false;
        }

        visit[i] = true;
        path[i] = true;
        for (int neigh : adj.get(i)) {
            if (dfs(neigh, adj, visit, path)) {
                return true;
            }
        }

        path[i] = false;
        return false;
    }
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] temp : prerequisites) {
            adj.get(temp[0]).add(temp[1]);
        }

        boolean[] visit = new boolean[n];
        boolean[] path = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (dfs(i, adj, visit, path)) {
                return false;
            }
        }
        return true;
    }
}
