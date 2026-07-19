class Solution {
    private int visitedCount = 0;
    public boolean solve(int curr, int par, List<List<Integer>> adj, boolean[] visit) {
        visit[curr] = true;
        visitedCount++;
        for (int neigh : adj.get(curr)) {
            if (visit[neigh]) {
                if (neigh != par)
                    return true;
            } else if (solve(neigh, curr, adj, visit)) {
                return true;
            }
        }
        return false;
    }
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visit = new boolean[n];
        visitedCount = 0;
        if (solve(0, -1, adj, visit) || visitedCount != n) {
            return false;
        }
        return true;
    }
}