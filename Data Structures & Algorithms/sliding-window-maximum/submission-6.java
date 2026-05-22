class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1)
            return nums;
        // Initialize deque
        Deque<Integer> queue = new ArrayDeque<>();
        // initialzie the ans aray
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (queue.peekFirst() + k <= i)
                queue.pollFirst();

            if (i >= k - 1) {
                ans[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return ans;
    }
}
