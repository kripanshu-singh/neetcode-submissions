class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> nse = new ArrayDeque<>();
        Deque<Integer> pse = new ArrayDeque<>();
        int n = heights.length;
        // if (n == 1)
        //     return heights[0];
        int[] nseArr = new int[n];
        int[] pseArr = new int[n];
        Arrays.fill(nseArr, n);
        Arrays.fill(pseArr, -1);
        for (int i = 0; i < n; i++) {
            while (!nse.isEmpty() && heights[nse.peek()] > heights[i]) {
                int ind = nse.pop();
                nseArr[ind] = i;
            }
            nse.push(i);
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!pse.isEmpty() && heights[pse.peek()] > heights[i]) {
                int ind = pse.pop();
                pseArr[ind] = i;
            }
            pse.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int length = heights[i];
            int breadth = nseArr[i] - pseArr[i] - 1;
            int area = length * breadth;
            ans = Math.max(ans, area);
        }
        return ans;
    }
}
