class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // initialzie the ans aray
        int n = nums.length;
        if(k == 1)return nums;
        int[] ans = new int[n - k + 1];
        for(int i = 0; i<n-k+1; i++){
            int maxi = Integer.MIN_VALUE;
            for(int j = i; j<i+k; j++){
                maxi = Math.max(maxi, nums[j]);
            }
            ans[i] = maxi;
        }
        return ans;
    }
}
