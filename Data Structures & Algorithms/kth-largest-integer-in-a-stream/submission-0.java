class KthLargest {
    Queue<Integer> mini = new PriorityQueue<>();
    int n = 0;
    public KthLargest(int k, int[] nums) {
        n = k;
        for (int i = 0; i < nums.length; i++) {
            if (mini.size() == k) {
                if (nums[i] < mini.peek())
                    continue;
                else {
                    mini.poll();
                    mini.offer(nums[i]);
                }

            } else {
                mini.offer(nums[i]);
            }
        }
    }

    public int add(int val) {
        if (mini.size() == n) {
            if (val < mini.peek())
                return mini.peek();
            else {
                mini.poll();
                mini.offer(val);
            }

        } else {
            mini.offer(val);
        }
        return mini.peek();
    }
}
