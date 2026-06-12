class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> mini = new PriorityQueue<>();
        for(int num:nums){
            mini.offer(num);

            if(mini.size() > k)mini.poll();
        }
        return mini.poll();
    }
}
