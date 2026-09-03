class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visit = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                q.offer(i);
                while (!q.isEmpty()) {
                    int curr = q.poll();
                    List<Integer> neighs = adj.get(curr);
                    for (int neigh : neighs) {
                        if (!visit[neigh]) {
                            visit[neigh] = true;
                            q.offer(neigh);
                        }
                    }
                }
                ans++;
            }
        }
        return ans;
    }
}
