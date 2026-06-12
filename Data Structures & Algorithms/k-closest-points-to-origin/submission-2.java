class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        Queue<int[]> maxi = new PriorityQueue<>(
            (a, b) -> Integer.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1])));
        for (int i = 0; i < points.length; i++) {
            maxi.offer(points[i]);
            if (maxi.size() > k) {
                maxi.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            ans[i] = maxi.poll();
        }
        return ans;
    }
}