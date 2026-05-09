class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int count = 0;
        int zeroInd = 0;

        for (int i = 0; i<nums.length; i++) {
            if (nums[i] == 0) {
                count++;
                zeroInd = i;
                continue;
            }
            prod *= nums[i];
        }
        int[] ans = new int[nums.length];
        if (count > 1)
            return ans;
        else if (count == 1) {
            ans[zeroInd] = prod;
            return ans;
        }

        for (int i = 0; i < nums.length; i++) {
           
                ans[i] = prod / nums[i];
        }
        return ans;
    }
}
